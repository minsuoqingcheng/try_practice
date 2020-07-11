package order.borrow_umbrella;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowUmbrellaForm {

    private Long rackId;
    private Long roleId;
    private Long orderId;

}
