package jvm;

import java.util.ArrayList;
import java.util.List;

public class StringInternTest {

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        int i = 0;
        while (true) {
            arr.add(String.valueOf(i++).intern());
        }
    }

}
