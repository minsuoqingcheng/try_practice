package order.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

public class RentFeeCalculate {
    private static final BigDecimal MILLION_TO_MINUTE = BigDecimal.valueOf(60000);
    // 分钟、小时、天、月、年
    private static final BigDecimal[] TIME_UNIT = {
            BigDecimal.ONE, BigDecimal.valueOf(60), BigDecimal.valueOf(1440),
            BigDecimal.valueOf(43200), BigDecimal.valueOf(518400)
    };

    public static BigDecimal calculate(RentStrategyDTO rentStrategy, Timestamp beginTime, Timestamp endTime) {
        long time = endTime.getTime() - beginTime.getTime();
        return rentStrategy.getPrice().multiply(BigDecimal.valueOf(time)
                        .divide(MILLION_TO_MINUTE, 2, RoundingMode.HALF_UP)
                        .divide(TIME_UNIT[rentStrategy.getRentUnit()], 2, RoundingMode.HALF_UP));
    }
}
