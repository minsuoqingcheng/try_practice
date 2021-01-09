package service_breaker.strategy;

import service_breaker.core.Metrics;

public interface FuseStrategyExecutor {

    boolean breaking(Metrics metrics);

}
