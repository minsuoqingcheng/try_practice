package service_breaker.strategy;

import lombok.Data;

@Data
public class FuseStrategyOption {

    private FuseStrategy strategy;
    private long consecutiveFailThreshold;
    private long failThreshold;
    private float failRate;
    private long minCall;

}
