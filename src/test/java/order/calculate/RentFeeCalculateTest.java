package order.calculate;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

public class RentFeeCalculateTest {

    @Test
    public void testCalculateWithMinute() {
        RentStrategyDTO rentStrategyDTO = new RentStrategyDTO(BigDecimal.ONE, 0);
        Timestamp beginTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 10, 10));
        Timestamp endTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 11, 40));
        BigDecimal fee = RentFeeCalculate.calculate(rentStrategyDTO, beginTime, endTime);
        Assert.assertEquals(new BigDecimal(1.5).setScale(2, RoundingMode.HALF_UP), fee);
    }

    @Test
    public void testCalculateWithHour() {
        RentStrategyDTO rentStrategyDTO = new RentStrategyDTO(BigDecimal.ONE, 1);
        Timestamp beginTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 10, 10));
        Timestamp endTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 11, 11, 10));
        BigDecimal fee = RentFeeCalculate.calculate(rentStrategyDTO, beginTime, endTime);
        Assert.assertEquals(new BigDecimal(1.02).setScale(2, RoundingMode.HALF_UP), fee);
    }

    @Test
    public void testCalculateWithDay() {
        RentStrategyDTO rentStrategyDTO = new RentStrategyDTO(BigDecimal.ONE, 2);
        Timestamp beginTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 10, 10));
        Timestamp endTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 15, 10, 10, 10));
        BigDecimal fee = RentFeeCalculate.calculate(rentStrategyDTO, beginTime, endTime);
        Assert.assertEquals(new BigDecimal(5.00).setScale(2, RoundingMode.HALF_UP), fee);
    }


    @Test
    public void testCalculateWithMonth() {
        RentStrategyDTO rentStrategyDTO = new RentStrategyDTO(BigDecimal.ONE, 3);
        Timestamp beginTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 10, 10));
        Timestamp endTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.OCTOBER, 25, 10, 10, 10));
        BigDecimal fee = RentFeeCalculate.calculate(rentStrategyDTO, beginTime, endTime);
        Assert.assertEquals(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP), fee);
    }


    @Test
    public void testCalculateWithYear() {
        RentStrategyDTO rentStrategyDTO = new RentStrategyDTO(BigDecimal.ONE, 4);
        Timestamp beginTime = Timestamp.valueOf(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 10, 10));
        Timestamp endTime = Timestamp.valueOf(LocalDateTime.of(2020, Month.SEPTEMBER, 10, 10, 10, 10));
        BigDecimal fee = RentFeeCalculate.calculate(rentStrategyDTO, beginTime, endTime);
        Assert.assertEquals(new BigDecimal(1.02).setScale(2, RoundingMode.HALF_UP), fee);
    }

}
