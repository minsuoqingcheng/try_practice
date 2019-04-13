package thread;

import java.util.concurrent.Semaphore;

public class FairSemaphore {

    private static int number = 0;

    public static void main(String[] args) {

        int N = 5;
        Semaphore semaphore = new Semaphore(1, true);
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        semaphore.acquire();
                        if (number > 100) {
                            break;
                        }
                        System.out.println("index " + finalI + " print the number: "+ number);
                        number++;
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();

                    }
                }
            });
            threads[i] = thread;
        }

        for (int i = 0; i < N; i++) {
            threads[i].start();

        }
    }

}
