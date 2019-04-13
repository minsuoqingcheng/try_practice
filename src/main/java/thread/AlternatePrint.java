package thread;

public class AlternatePrint {


    public static void main(String[] args) {

        //能够精确的交替打印
        new Thread(new Solution()).start();
        new Thread(new Solution()).start();

        //不能够精确的交替打印
        new Thread(new Solution2()).start();
        new Thread(new Solution2()).start();

    }




    static class Solution implements Runnable {

        private static int number = 0;

        @Override
        public void run() {
            while (number < 100) {
                synchronized (Solution.class) {
                    System.out.println(Thread.currentThread().getName() + " print the number: " + number++);
                    Solution.class.notify();
                    //这边需要加上退出条件，number == 100，否则应用不会退出，打印99数字的线程会一直等待被唤醒
                    if (number == 100) {
                        return;
                    }
                    try {
                        Solution.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    static class Solution2 implements Runnable {

        private static int number = 0;

        @Override
        public void run() {
            while (number < 100) {
                System.out.println(Thread.currentThread().getName() + " print the number: " + number++);
                Thread.yield();
            }
        }
    }

}
