package java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());

        LocalDateTime parse = LocalDateTime.parse("2019-05-30 08:55:42", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);

    }

}
