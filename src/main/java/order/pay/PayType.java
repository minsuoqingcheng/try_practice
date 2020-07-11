package order.pay;

import lombok.Getter;

@Getter
public enum PayType {

    ALIPAY(1);

    private int type;

    PayType(int type) {
        this.type = type;
    }
}
