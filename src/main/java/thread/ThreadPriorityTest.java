package thread;

public class ThreadPriorityTest {

    public static void main(String[] args) {
        PriorityLowThread lowThread = new PriorityLowThread();
        lowThread.setPriority(Thread.MIN_PRIORITY);
        lowThread.start();
        PriorityHighThread highThread = new PriorityHighThread();
        highThread.setPriority(Thread.MIN_PRIORITY);
        highThread.start();
    }


    static class PriorityHighThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("high");
            }
        }

    }


    static class PriorityLowThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("low");
            }
        }
    }
}
