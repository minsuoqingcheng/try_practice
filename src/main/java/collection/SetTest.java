package collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<Integer> iset = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            iset.add(i);
        }
        iset.add(15);
        iset.add(30);   //0 1 2 3 4 5 6 7 8 9 30 15
        iset.forEach(System.out::print);

        System.out.println();

        Set<String> sset = new HashSet<>();
        sset.add("student");
        sset.add("teacher");
        sset.add("sience");
        sset.forEach(System.out::println);
    }

}
