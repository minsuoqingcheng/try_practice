package order.umbrella_rent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import order.borrow_umbrella.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddScheduleOperationService extends AbstractScheduleOperationService {

    @Override
    protected void changeUmbrellaShelves(OperationForm form) {
        Long rackId = form.getRackId();
        String res = iotServerWrapper.callDevice(getDeviceConfigFromRackId(rackId), OperationEnum.ADMIN_IN, form.getRoleId());
        JSONObject resultObject = JSON.parseObject(res);
        BatchScheduleResult scheduleResult = JSON.parseObject(resultObject.getString("data"), BatchScheduleResult.class);
        if (scheduleResult.getResultEnum() == ResultEnum.SUCCESS) {
            List<UmbrellaShelveEntity> entities = UmbrellaShelveEntity.constructFrom(rackId, scheduleResult.getUmbrellaInstanceId());
            umbrellaShelvesDao.updateShelve(entities);
        }
        /* 失败处理 */
    }

    @Override
    protected void changeRentStrategy(OperationForm form) {
        Long rackId = form.getRackId();
        Long roleId = form.getRoleId();
        boolean existRentStrategy = rentStrategyService.existUmbrellaRentStrategy(rackId);
        if (!existRentStrategy) {
            rentStrategyService.createDefaultRentStrategy(roleId, rackId);
        }
    }

    @Override
    public OperationType getCanHandleOperation() {
        return OperationType.ADD;
    }

    private DeviceConfig getDeviceConfigFromRackId(Long rackId) {
        return new DeviceConfig();
    }
}
