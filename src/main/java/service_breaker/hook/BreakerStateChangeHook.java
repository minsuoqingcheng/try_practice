package service_breaker.hook;

import service_breaker.core.BreakerState;

import java.time.LocalDateTime;

public interface BreakerStateChangeHook {

    void stateChanged(BreakerState prev, BreakerState now, LocalDateTime changeTime);

}
