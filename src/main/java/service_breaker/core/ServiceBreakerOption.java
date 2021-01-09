package service_breaker.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import service_breaker.hook.BreakerStateChangeHook;
import service_breaker.strategy.FuseStrategyOption;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ServiceBreakerOption {

    private String name;
    private Duration windowInterval;
    private long halfMaxCalls;
    private Duration sleepTimeout;
    private BreakerStateChangeHook hook;
    private FuseStrategyOption strategyOption;

}
