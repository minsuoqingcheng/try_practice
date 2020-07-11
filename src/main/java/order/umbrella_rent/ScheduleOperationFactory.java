package order.umbrella_rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleOperationFactory {

    @Autowired
    private List<AbstractScheduleOperationService> serviceList;

    public AbstractScheduleOperationService getServiceByOperationType(OperationType operationType) {
        return serviceList.stream().filter(s -> s.getCanHandleOperation().equals(operationType)).findFirst().get();
    }
}
