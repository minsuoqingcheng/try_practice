package question_every_day.array_deque_test;

import java.util.ArrayDeque;

public class ArrayDequeTest {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        System.out.println(arrayDeque);

        /*
            从ArrayDeque中删除“头元素”
            head = (h + 1) & (elements.length - 1);
                将head位数向后移一位：因为后面的添加的元素可能在数组的前面，用位运算能够保证head位置的正确。

         */
//        public E pollFirst() {
//            int h = head;
//            @SuppressWarnings("unchecked")
//            E result = (E) elements[h];
//            // Element is null if deque empty
//            if (result == null)
//                return null;
//            elements[h] = null;     // Must null out slot
//            head = (h + 1) & (elements.length - 1);
//            return result;
//        }

        /*
            向ArrayDeque中添加元素(tail位的元素)
            (tail = (tail + 1) & (elements.length - 1))
                这边tail后移一位的算法与前面对head的处理一致，因为这样可以保证如果数组前面的位置为空(被poll出来)，
                可以继续将新添加的元素放在数组前面空着的位置。
            System.arraycopy(elements, p, a, 0, r);
            System.arraycopy(elements, 0, a, r, p);
                将元素按照head在前面，tail在后的顺序拷贝(拷贝两次是因为可能出现tail小于head的情况)
         */


//        public void addLast(E e) {
//            if (e == null)
//                throw new NullPointerException();
//            elements[tail] = e;
//            if ( (tail = (tail + 1) & (elements.length - 1)) == head)
//                doubleCapacity();
//        }

//        private void doubleCapacity() {
//            assert head == tail;
//            int p = head;
//            int n = elements.length;
//            int r = n - p; // number of elements to the right of p
//            int newCapacity = n << 1;
//            if (newCapacity < 0)
//                throw new IllegalStateException("Sorry, deque too big");
//            Object[] a = new Object[newCapacity];
//            System.arraycopy(elements, p, a, 0, r);
//            System.arraycopy(elements, 0, a, r, p);
//            elements = a;
//            head = 0;
//            tail = n;
//        }


    }



}
