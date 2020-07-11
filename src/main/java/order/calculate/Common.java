package order.calculate;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Common {

    public static void main(String[] args) {
        Map<String, Object> o = new HashMap<>();
        o.put("1", new Timestamp(System.currentTimeMillis()));
        o.put("2", 2L);
        Timestamp t = (Timestamp) o.get("1");

        Long n = (Long) o.get("2");
        System.out.println(t);
        System.out.println(n);
        Timestamp t2 = new Timestamp(System.currentTimeMillis());
    }

}
