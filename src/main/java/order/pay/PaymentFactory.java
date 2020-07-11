package order.pay;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentFactory {

    @Autowired
    private List<PaymentProvider> providers;
    private Map<Integer, PaymentProvider> type2provider;

    @PostConstruct
    private void init() {
        type2provider = new HashMap<>();
        if (CollectionUtils.isNotEmpty(providers)) {
            providers.forEach(p -> type2provider.put(p.getPayType().getType(), p));
        }
    }

}
