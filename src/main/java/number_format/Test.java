package number_format;

import java.text.NumberFormat;

public class Test {

    public static void main(String[] args) {

        NumberFormatFactory formatFactory = new NumberFormatFactory();
        NumberFormat oneFormat = formatFactory.oneDecimal();
        NumberFormat twoFormat = formatFactory.twoDecimal();
        System.out.println(oneFormat.format(2.94));     //四舍五入
        System.out.println(twoFormat.format(2.98));
        System.out.println(twoFormat.format(2.999));
    }

}
