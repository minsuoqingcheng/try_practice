package service_breaker.test;

import service_breaker.core.ServiceBreaker;
import service_breaker.core.ServiceBreakerOption;
import service_breaker.strategy.FuseStrategy;
import service_breaker.strategy.FuseStrategyOption;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ServiceBreakerTest {

    public static void main(String[] args) throws Exception {

        FuseStrategyOption fuseStrategyOption = new FuseStrategyOption();
        fuseStrategyOption.setStrategy(FuseStrategy.FAIL_COUNT);
        fuseStrategyOption.setFailThreshold(3);

        ServiceBreakerOption serviceBreakerOption = new ServiceBreakerOption();
        serviceBreakerOption.setName("test");
        serviceBreakerOption.setHalfMaxCalls(3);
        serviceBreakerOption.setStrategyOption(fuseStrategyOption);
        serviceBreakerOption.setWindowInterval(Duration.of(5, ChronoUnit.SECONDS));
        serviceBreakerOption.setSleepTimeout(Duration.of(6, ChronoUnit.SECONDS));

        ServiceBreaker serviceBreaker = new ServiceBreaker(serviceBreakerOption);
        RealObject realObject = new RealObject();
        for (int i = 0; i < 30; i++) {
            try {
                serviceBreaker.invoke(RealObject.class.getMethod("call", int.class), realObject, i);

            } catch (Exception e) {

            }
            Thread.sleep(1000);

        }
    }

}
