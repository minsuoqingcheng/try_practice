package thread;

public class WaitAndNotify {

    private final Object object = new Object();
    //
    //Thrown to indicate that a thread has attempted to wait on an object's monitor or
    // to notify other threads waiting on an object's monitor
    // without owning the specified monitor.
    //调用一个Object的wait与notify/notifyAll的时候，必须保证调用代码对该Object是同步的，
    // 也就是说必须在作用等同于synchronized(obj){......}的内部才能够去调用obj的wait与notify/notifyAll三个方法
    public synchronized void testWait(int i) {
        try {
            System.out.println("prepare wait " + i);
            Thread.yield();     //调用yield方法，都一个线程会暂停一段时间，但是并不会释放锁，有更多的线程start()，打印顺序会发生变化
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get notify " + i);
    }


    public synchronized void testNotify() {
        this.notifyAll();
        System.out.println("notify");
    }


    public void testWait2() {
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            Thread t = new Thread(() -> waitAndNotify.testWait(finalI));
            t.start();
        }
        Thread t3 = new Thread(waitAndNotify::testNotify);
        Thread.sleep(1000);
        t3.start();
    }

}
