package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.next();
        iterator.remove();
//        iterator.next();      这个next()方法必须要调用，否则会报错 throw new IllegalStateException();
        iterator.remove();

        /**
         * public E next() {
         checkForComodification();
         int i = cursor;
         if (i >= size)
         throw new NoSuchElementException();
         Object[] elementData = ArrayList.this.elementData;
         if (i >= elementData.length)
         throw new ConcurrentModificationException();
         cursor = i + 1;
         return (E) elementData[lastRet = i];
         }

         public void remove() {
         if (lastRet < 0)
         throw new IllegalStateException();
         checkForComodification();

         try {
         ArrayList.this.remove(lastRet);
         cursor = lastRet;
         lastRet = -1;
         expectedModCount = modCount;
         } catch (IndexOutOfBoundsException ex) {
         throw new ConcurrentModificationException();
         }
         }
         */
    }

}
