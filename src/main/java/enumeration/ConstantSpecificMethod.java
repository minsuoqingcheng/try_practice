package enumeration;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum ConstantSpecificMethod {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    };

    private final String symbol;

    ConstantSpecificMethod(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, ConstantSpecificMethod> stringToEnum =
            Stream.of(values()).collect(toMap(ConstantSpecificMethod::toString, e -> e));

}
