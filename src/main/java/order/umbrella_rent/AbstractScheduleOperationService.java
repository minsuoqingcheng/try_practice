package order.umbrella_rent;

import order.borrow_umbrella.IOTServerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractScheduleOperationService {
    @Autowired
    IOTServerWrapper iotServerWrapper;
    @Autowired
    UmbrellaShelvesDao umbrellaShelvesDao;
    @Autowired
    RentStrategyService rentStrategyService;
    //调度雨伞
    public boolean doSchedule(OperationForm form) {
        changeUmbrellaShelves(form);
        changeRentStrategy(form);
        return true;
    }
    protected abstract void changeUmbrellaShelves(OperationForm form);

    protected abstract void changeRentStrategy(OperationForm form);

    public abstract OperationType getCanHandleOperation();
}
