package iterator_test;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastIteratorTest {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                // will not throw Exception
                al.remove(2);
            }
        }
        System.out.println(al);
        itr = al.iterator();
        for (int i = 0; i < al.size(); i++) {
            int ele = itr.next();
            System.out.println(ele);
            if (ele == 4) {
                al.remove(i);
            }
        }
    }

}
