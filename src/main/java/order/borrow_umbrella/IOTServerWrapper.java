package order.borrow_umbrella;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IOTServerWrapper {

    private static final String clientId = "";
    private static final String secret = "";
    private static final String productKey = "";
    private static final String nonce = "";
    private static final String callUrl = "";

    @Autowired
    private OkHttpClient okHttpClient;

    public String callDevice(DeviceConfig deviceConfig, OperationEnum operationEnum, Long roleId) {
        Long now = System.currentTimeMillis();
        OperationDto operationDto = new OperationDto();
        operationDto.setClientId(clientId);
        operationDto.setSecret(secret);
        operationDto.setNonce(nonce);
        operationDto.setTimestamp(now);
        operationDto.setDeviceName(deviceConfig.getName());
        operationDto.setSign(getSign(now));
        operationDto.setProductKey(productKey);
        DataDecoratorDto dataDto = new DataDecoratorDto(
                deviceConfig.getName(),
                deviceConfig.getId(),
                operationEnum.getOperation(),
                "",
                productKey,
                now,
                operationEnum.getUmbrellaRoad(),
                roleId+""
        );
        operationDto.setData(JSON.toJSONString(dataDto));
        String res = "";
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(operationDto));
            Request request = (new Request.Builder()).url(callUrl).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            res = response.body().string();
        } catch (Exception e) {
            log.error("operate device error for {}", e.getMessage());
        }
        return res;
    }

    public String callDevice(DeviceConfig deviceConfig, OperationEnum operationEnum, Long roleId, String orderId) {
        Long now = System.currentTimeMillis();
        OperationDto operationDto = new OperationDto();
        operationDto.setClientId(clientId);
        operationDto.setSecret(secret);
        operationDto.setNonce(nonce);
        operationDto.setTimestamp(now);
        operationDto.setDeviceName(deviceConfig.getName());
        operationDto.setSign(getSign(now));
        operationDto.setProductKey(productKey);
        DataDecoratorDto dataDto = new DataDecoratorDto(
                deviceConfig.getName(),
                deviceConfig.getId(),
                operationEnum.getOperation(),
                orderId,
                productKey,
                now,
                operationEnum.getUmbrellaRoad(),
                roleId+""
        );
        operationDto.setData(JSON.toJSONString(dataDto));
        String res = "";
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(operationDto));
            Request request = (new Request.Builder()).url(callUrl).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            res = response.body().string();
        } catch (Exception e) {
            log.error("operate device error for {}", e.getMessage());
        }
        return res;
    }

    private String getSign(Long time) {
        String clientAndSecret = clientId.concat(secret);
        return Md5Util.md5(clientAndSecret + time + nonce);
    }


}
