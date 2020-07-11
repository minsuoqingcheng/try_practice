package order.umbrella_rent;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RentStrategyEntity {

    public RentStrategyEntity(UpdateRentStrategyForm form) {

    }

    private Long rackId;
    private Long roleId;
    private BigDecimal defaultDeposit;
    private BigDecimal defaultBuyPrice;
    private BigDecimal defaultRentPrice;
    private int defaultRentUnit;

}
