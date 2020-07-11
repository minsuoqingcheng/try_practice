package order.borrow_umbrella;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordDTO {

    public RecordDTO(BorrowUmbrellaForm form) {
    }



    private Long id;
    private Long orderId;
    private Long rackId;

    private Long roleId;


    private String operation;

    private Long rentTime;

    private Long returnTime;

    private Long returnRoleId;

    private String umbrellaId;

    private String rawData;

    private String adminOper;

    private Long affairId;

}
