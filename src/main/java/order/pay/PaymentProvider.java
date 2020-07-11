package order.pay;

public interface PaymentProvider {

    PaymentProvider getProvider();

    PayType getPayType();

}
