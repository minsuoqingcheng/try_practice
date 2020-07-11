package order.borrow_umbrella;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmbrellaRentInfoVO {

    private boolean existOngoingOrder;
    private Long orderId;

    public void setRackDetail(RackDetailDTO rackDetail) {

    }

}
