import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Integer> tests = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tests.add(i);
        }
        System.out.println(tests);
        Collections.shuffle(tests);
        System.out.println(tests);

    }

}
