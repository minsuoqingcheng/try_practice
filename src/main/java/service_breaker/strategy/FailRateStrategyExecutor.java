package service_breaker.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service_breaker.core.Metrics;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailRateStrategyExecutor implements FuseStrategyExecutor {

    private long minCall;
    private float rate;

    @Override
    public boolean breaking(Metrics metrics) {
        float currentRate = 0;
        if (metrics.getCountAll() != 0) {
            currentRate = (float) metrics.getCountFail() / (float) metrics.getCountAll();
        }
        return metrics.getCountAll() >= minCall && currentRate >= rate;
    }
}
