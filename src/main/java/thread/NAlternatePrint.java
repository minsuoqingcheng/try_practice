package thread;

import java.util.concurrent.Semaphore;

public class NAlternatePrint {

    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        Semaphore[] semaphores = new Semaphore[N];
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != N - 1) {
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < N; i++) {
            Semaphore last = i == 0 ? semaphores[N-1] : semaphores[i-1];
            Semaphore current = semaphores[i];
            int finalI = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        last.acquire();
                        if (number > 100) {
                            break;
                        }
                        System.out.println("Index " + finalI + " print the number: "+ number);
                        number++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        current.release();
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
