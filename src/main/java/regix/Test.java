package regix;

public class Test {

    public static void main(String[] args) {
        String key = "[下单：]title";
        String value1 = "123456";
        value1 = key.replace("title", value1);
        System.out.println(value1);
    }

}
