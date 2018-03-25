import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(9);

        print(integers);

        List<String> s1 = new ArrayList<>();
        s1.add("s1_1");
        s1.add("s1_2");

        List<String> s2 = new ArrayList<>();
        s2.add("s2_1");
        s2.add("s2_2");

        List<List<String>> ss = new ArrayList<>();
        ss.add(s1);
        ss.add(s2);

        print(ss);

    }

    private static void print(List<?> list) {
        list.forEach(System.out::println);
    }

}
