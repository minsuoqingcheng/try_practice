package grade4.consumer_and_supplier;

public class FunctionTest {

    public static void main(String[] args) {

        PrintFunction function = (String param) -> {
            param = "test" + param;
            System.out.println(param);
        };

        function.print("a");

    }

}
