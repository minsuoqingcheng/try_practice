package service_breaker.core;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import service_breaker.hook.BreakerStateChangeHook;
import service_breaker.strategy.FuseStrategyChooseFactory;
import service_breaker.strategy.FuseStrategyExecutor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Slf4j
public class ServiceBreaker {

    private Lock readLock;
    private Lock writeLock;
    private String name;
    private BreakerState state;
    private Duration windowInterval;
    private Metrics metrics;
    private FuseStrategyExecutor executor;
    private long halfMaxCalls;      //当断路器是半开时，允许的调用次数
    private Duration sleepTimeout;  //当断路器打开时，过多长时间重新计算
    private BreakerStateChangeHook hook;
    private LocalDateTime stateOpenTime;

    public ServiceBreaker() {
    }

    public ServiceBreaker(ServiceBreakerOption option) {
        if (Objects.isNull(option)
                || Objects.isNull(option.getWindowInterval()) || Duration.ZERO.compareTo(option.getWindowInterval()) >= 0
                || option.getHalfMaxCalls() <= 0
                || Objects.isNull(option.getSleepTimeout()) || Duration.ZERO.compareTo(option.getSleepTimeout()) >= 0) {
            throw new IllegalArgumentException("init ServiceBreaker error");
        }
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.name = option.getName();
        this.state = BreakerState.CLOSED;
        this.windowInterval = option.getWindowInterval();
        this.metrics = new Metrics();
        this.executor = FuseStrategyChooseFactory.getStrategyExecutor(option.getStrategyOption());
        this.halfMaxCalls = option.getHalfMaxCalls();
        this.sleepTimeout = option.getSleepTimeout();
        this.hook = option.getHook();

        this.nextWindow(LocalDateTime.now());
    }


    public Object invoke(Method method, Object obj, Object... args) throws Exception {
        log.info("service breaker is running, name is {}, state is {}", this.name, this.state);
        method.setAccessible(true);
        beforeCall();
        Object res = null;
        Exception callException = null;

        try {
            this.metrics.onCall();
            res = method.invoke(obj, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("reflect error, exception is {}", e.getMessage());
        } catch (Exception e) {
            callException = e;
        }

        afterCall(callException);

        if (Objects.nonNull(callException)) {
            throw callException;
        }
        return res;
    }


    private void beforeCall() {
        try {
            this.writeLock.lock();
            LocalDateTime now = LocalDateTime.now();
            switch (this.state) {
                case OPEN:
                    if (this.stateOpenTime.plusNanos(this.sleepTimeout.toNanos()).isBefore(now)) {
                        log.info("break open sleep time end, turn to half open");
                        changeState(BreakerState.HALF_OPEN, now);
                    }
                    throw new BreakOpenException("break is open");
                case HALF_OPEN:
                    if (this.metrics.getCountAll() >= this.halfMaxCalls) {
                        log.info("break is half open and total request greater than max call");
                        changeState(BreakerState.OPEN, now);
                        throw new BreakOpenException("break is half open");
                    }
                case CLOSED:
                    if (this.metrics.getNextWindowTimeStart().isBefore(now)) {
                        nextWindow(now);
                    }
            }

        } finally {
            this.writeLock.unlock();
        }

    }


    private void afterCall(Exception callException) {
        try {
            writeLock.lock();
            if (callException == null) {
                onSuccess(LocalDateTime.now());
            } else {
                onFail(LocalDateTime.now());
            }
        } finally {
            writeLock.unlock();
        }
    }


    private void onSuccess(LocalDateTime now) {
        this.metrics.onSuccess();
        if (this.state == BreakerState.HALF_OPEN && this.metrics.getConsecutiveSuccess() >= halfMaxCalls) {
            changeState(BreakerState.CLOSED, now);
        }
    }

    private void onFail(LocalDateTime now) {
        this.metrics.onFail();
        if (this.state == BreakerState.CLOSED) {
            if (executor.breaking(this.metrics)) {
                changeState(BreakerState.OPEN, now);
            }
        }
    }



    private void changeState(BreakerState state, LocalDateTime time) {
        if (this.state == state) {
            return;
        }
        BreakerState prevState = this.state;
        this.state = state;

        //更新状态，进入下个窗口
        nextWindow(LocalDateTime.now());

        if (state == BreakerState.OPEN) {
            this.stateOpenTime = time;
        }

        if (this.hook != null) {
            hook.stateChanged(prevState, state, time);
        }
    }


    private void nextWindow(LocalDateTime now) {
        this.metrics.newBatch();
        this.metrics.reset();
        switch (this.state) {
            case CLOSED:
                this.metrics.setNextWindowTimeStart(
                        now.plusNanos(this.windowInterval.toNanos())
                );
                break;
            case OPEN:
                this.metrics.setNextWindowTimeStart(
                        now.plusNanos(this.sleepTimeout.toNanos())
                );
                break;
            case HALF_OPEN:
                this.metrics.setNextWindowTimeStart(null);
                break;
        }
    }




}
