package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(0);
        List<Integer> unmodifiable = Collections.unmodifiableList(array);   //an unmodifiable view of the specified list.
        System.out.println(array.toString());
        System.out.println(unmodifiable);
        System.out.println("==================");

        array.add(1);
        System.out.println(array.toString());
        System.out.println(unmodifiable);

        System.out.println("==================");


        List<Integer> realUnmodifiable = Collections.unmodifiableList(new ArrayList<>(array));
        array.add(2);
        System.out.println(array.toString());
        System.out.println(unmodifiable);
        System.out.println(realUnmodifiable);
    }

}
