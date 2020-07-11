package order.borrow_umbrella;

import lombok.Data;

@Data
public class OperationDto {

    private String clientId;
    private String secret;
    private String nonce;
    private Long timestamp;
    private String deviceName;
    private String sign;
    private String productKey;
    private String data;


}
