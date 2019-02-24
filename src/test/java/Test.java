import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//        List<Integer> tests = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            tests.add(i);
//        }
//        System.out.println(tests);
//        Collections.shuffle(tests);
//        System.out.println(tests);
//
//        Object o = new ArrayList<>();
        double data = 0.163;
        double res = (double) Math.round(data * 100) / 100;
        System.out.println(res);

    }

    private static void print(List<?> list) {
        list.forEach(System.out::println);
    }


    public static Timestamp toTimeStamp(String time) {
        int length = time.length();
        time = time.substring(0, length-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return new Timestamp(sdf.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(System.currentTimeMillis());
    }

}
