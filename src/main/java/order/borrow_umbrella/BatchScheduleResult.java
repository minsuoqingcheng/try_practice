package order.borrow_umbrella;

import lombok.Data;

import java.util.List;

@Data
public class BatchScheduleResult {

    private ResultEnum resultEnum;
    private List<Long> umbrellaInstanceId;

}
