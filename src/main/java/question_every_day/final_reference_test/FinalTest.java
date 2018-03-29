package question_every_day.final_reference_test;

public class FinalTest {

    private final Person p = new Person(1);

    public void testChangeFinalReference() {
//        p = new Person(10);   //无法编译通过
        p.setAge(20);   //可以操作它指向的对象
        //为了不可变，可以直接将原对象的field设置为final。
    }

    public Person getP() {
        return p;
    }

    public static void main(String[] args) {
        FinalTest t = new FinalTest();
        Person p = t.getP();
        p.setAge(10);
        System.out.println(p.getAge());     //打印10，final是作用于引用p，引用p不可以在指向其它对象
        t.testChangeFinalReference();
        System.out.println(p.getAge());     //20
    }

}
