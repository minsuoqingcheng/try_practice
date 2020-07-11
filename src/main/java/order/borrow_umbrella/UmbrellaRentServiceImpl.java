package order.borrow_umbrella;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import order.ErrorCodeException;
import order.ResponseCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UmbrellaRentServiceImpl implements UmbrellaRentService {

    private static final String UMBRELLA_KEY = "umbrellaInstanceId";

    private static final String TAKE_TIME = "take_time";

    private static final String RENT_STRATEGY = "rent_strategy";

    @Autowired
    private IOTServerWrapper iotServerWrapper;
    @Autowired
    private UmbrellaShelveWrapper umbrellaShelveWrapper;
    @Autowired
    private OrderWrapper orderWrapper;
    @Autowired
    private RecordService recordService;

    @Override
    public boolean borrow(BorrowUmbrellaForm form) {

        Long roleId = form.getRoleId();
        Long rackId = form.getRackId();
        Long orderId = form.getOrderId();
        DeviceConfig deviceConfig = new DeviceConfig();
        String iotOrderId = rackId + "" + System.currentTimeMillis();
        String result;
        try {
            result = iotServerWrapper.callDevice(deviceConfig, OperationEnum.BORROW, roleId, iotOrderId);
        } catch (Exception e) {
            log.error("error for call request ,orderId is {}", orderId);
            throw new ErrorCodeException(ResponseCode.TIME_OUT_ERROR);
        }
        JSONObject resultObject = JSON.parseObject(result);
        if (Objects.isNull(resultObject)) {
            throw new ErrorCodeException(ResponseCode.DEVICE_ERROR);
        }
        ResultDataDto resultDataDto = JSON.parseObject(resultObject.getString("data"), ResultDataDto.class);
        ResultEnum resultEnum = resultDataDto.getResultEnum();
        switch (resultEnum) {
            case FAIL:
                log.error("roleId: {} 取伞超时", roleId);
                return false;
            case LOCKED:
                log.error("roleId: {} 多人同时操作设备: {}", roleId, rackId);
                return false;
            case SUCCESS:
                Long umbrellaInstanceId = resultDataDto.getUmbrellaInstanceId();
                RecordDTO recordDTO = new RecordDTO(form);
                try {
                    umbrellaShelveWrapper.updateUmbrellaShelveInfo(FormConverter.toUpdateShelveForm(form));
                    recordService.save(recordDTO);
                    Map<String, Object> external = new HashMap<>();
                    external.put(UMBRELLA_KEY, umbrellaInstanceId);
                    external.put(TAKE_TIME, new Timestamp(System.currentTimeMillis()));
                    external.put(RENT_STRATEGY, umbrellaShelveWrapper.getRentStrategyDTO(rackId));
                    orderWrapper.confirmBorrow(orderId, external);
                    return true;
                } catch (Exception e) {
                    log.error("【重要】取伞成功，后续更新数据失败，请求数据为{}，请求时间为", form.toString(), LocalDateTime.now());
                    throw new ErrorCodeException(ResponseCode.DEVICE_ERROR);
                }
            default:
                return false;
        }
    }

    @Override
    public UmbrellaRentInfoVO showRentInfo(Long roleId, Long rackId) {
        UmbrellaRentInfoVO infoVO = new UmbrellaRentInfoVO();
        Long orderId = orderWrapper.existOngoingUmbrellaOrder(roleId);
        if (orderId != null) {
            infoVO.setExistOngoingOrder(true);
            infoVO.setOrderId(orderId);
        }
        RackDetailDTO rackDetailDTO = umbrellaShelveWrapper.getRackDetailDTO(rackId);
        infoVO.setRackDetail(rackDetailDTO);
        return infoVO;
    }
}
