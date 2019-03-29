package execption;

public class TryTest {

    public static void main(String[] args) {
        int value = test();
        System.out.println(value);

    }

    private static int test() {
        int i = 0;
        try {
            i = 1;
            return i;
        } finally {
            i = 2;
            System.out.println("test");
        }
    }

}
