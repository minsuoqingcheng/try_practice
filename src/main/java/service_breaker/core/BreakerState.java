package service_breaker.core;

import lombok.Getter;

@Getter
public enum BreakerState {

    CLOSED("closed"),
    OPEN("open"),
    HALF_OPEN("half-open")

    ;


    private String desc;

    BreakerState(String desc) {
        this.desc = desc;
    }
}
