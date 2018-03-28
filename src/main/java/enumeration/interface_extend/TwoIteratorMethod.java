package enumeration.interface_extend;

import java.util.Collection;

public class TwoIteratorMethod {

    public static void main(String[] args) {

    }

    //确保传入的Class类型既是枚举类型，也是Operation的子类
    public static <T extends Enum<T> & Operation> void withClassIterator(Class<T> opEnumType, double x, double y) {
        for (Operation operation : opEnumType.getEnumConstants()) {
            operation.apply(x, y);
        }
    }

    //将所有需要操作的枚举实例以集合的方式传入
    public static void withClooectionIterator(Collection<? extends Operation> operations, double x, double y) {
        for (Operation operation : operations) {
            operation.apply(x, y);
        }
    }
}
