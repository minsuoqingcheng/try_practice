package service_breaker.strategy;


public enum FuseStrategy {

    FAIL_COUNT,
    CONSECUTIVE_FAIL_COUNT,
    FAIL_RATE

}
