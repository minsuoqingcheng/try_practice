package order.pay;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AliPay implements PaymentProvider {

    private Long id;
    private String alipayPublicKey;
    private String appId;
    private PaymentProvider provider;


    @Override
    public PaymentProvider getProvider() {
        return provider;

    }

    @Override
    public PayType getPayType() {
        return null;
    }

}
