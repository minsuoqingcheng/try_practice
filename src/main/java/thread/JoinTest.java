package thread;

public class JoinTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start-----");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " end------");
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new JoinTest());
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished~~~");
    }
}