package order.umbrella_rent;

import lombok.Data;

@Data
public class AddOperationForm extends OperationForm {

    private Long rackId;
    private Long umbrellaInstanceId;

}
