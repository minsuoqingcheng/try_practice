package order.borrow_umbrella;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderWrapper {

    public void confirmBorrow(Long orderId, Map<String, Object> external) {

    }

    public boolean userExistsNotEndOrders(Long roleId, Long orderId) {
        return true;
    }

    public Long existOngoingUmbrellaOrder(Long roleId) {
        return null;
    }

}
