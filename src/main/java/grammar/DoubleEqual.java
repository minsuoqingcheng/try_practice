package grammar;

public class DoubleEqual {

    public static void main(String[] args) {

        //AQS中有段代码：node.prev = pred = pred.prev;
        //把node的前继节点以及前继节点 更新为前继节点的前继节点
        int a = 10;
        int b = 9;
        a = b = 1;
        System.out.println(a);
        System.out.println(b);

    }

}
