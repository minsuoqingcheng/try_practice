package service_breaker.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service_breaker.core.Metrics;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailCountStrategyExecutor implements FuseStrategyExecutor {

    private long threshold;

    @Override
    public boolean breaking(Metrics metrics) {
        return metrics.getCountFail() >= threshold;
    }
}
