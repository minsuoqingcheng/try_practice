package question_every_day.null_transfer_test;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Object o = maskNull(null);
        NullTransfer transfer = unmaskNull(o);
        System.out.println(transfer);
        //null 可以强转成任何类型
        Date d = (Date) null;
        System.out.println(d);
    }


    private static Object maskNull(Object value) {
        return (value == null ? NULL : value);
    }

    private static NullTransfer unmaskNull(Object value) {
        return (NullTransfer) (value == NULL ? null : value);
    }

    private static final Object NULL = new Object() {
        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "java.util.EnumMap.NULL";
        }
    };
}
