package service_breaker.strategy;

public class FuseStrategyChooseFactory {

    public static FuseStrategyExecutor getStrategyExecutor(FuseStrategyOption option) {
        switch (option.getStrategy()) {
            case FAIL_COUNT:
                return new FailCountStrategyExecutor(option.getFailThreshold());
            case FAIL_RATE:
                return new FailRateStrategyExecutor(option.getMinCall(), option.getFailRate());
            case CONSECUTIVE_FAIL_COUNT:
                return new ConsecutiveFailCountStrategyExecutor(option.getConsecutiveFailThreshold());
            default:
                throw new IllegalArgumentException("strategy is not defined");
        }
    }

}
