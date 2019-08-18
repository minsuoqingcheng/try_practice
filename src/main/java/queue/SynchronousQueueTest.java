package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(queue.take() + " ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        /**
         * Inserts the specified element into this queue if it is possible to do
         * so immediately without violating capacity restrictions, returning
         * {@code true} upon success and {@code false} if no space is currently
         * available.
         */
        System.out.print(queue.offer(-1) + " ");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    /**
                     * Inserts the specified element into this queue, waiting if necessary
                     * for space to become available.
                     */
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
