package generics;

import java.util.Random;

public class VarArgsTest {

    public static void main(String[] args) {
        Integer[] b = toArray(1, 2);
        System.out.println("===========");
        Integer[] a = pickTwo(1, 2, 3);     //ClassCastException




    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(new Random().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }


    static <T> T[] toArray(T... elements) {
        System.out.println(elements.getClass());
        return elements;
    }

}
