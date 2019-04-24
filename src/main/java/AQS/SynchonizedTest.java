package AQS;

public class SynchonizedTest {

    public synchronized void test() {       //在编译之后，用synchronized标识方法
        System.out.println("1");
    }


    public void print() {
        synchronized (this) {               //在编译之后，用monitor enter 和 monitor exist实现同步
            System.out.println("2");
        }
    }
}
