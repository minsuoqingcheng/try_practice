package order.borrow_umbrella;

import lombok.Getter;

@Getter
public enum  OperationEnum {

    ADMIN_IN("", ""),
    BORROW("", "");

    OperationEnum(String operation, String umbrellaRoad) {
        this.operation = operation;
        this.umbrellaRoad = umbrellaRoad;
    }

    private String operation;
    private String umbrellaRoad;

}
