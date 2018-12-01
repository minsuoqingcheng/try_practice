package class_test;

public class TestClassEqual {

    public static void main(String[] args) {
        Object o1 = Integer[].class;
        Object o2 = Object[].class;
        System.out.println(o1==o2);
        Object o3 = Integer[].class;
        System.out.println(o1==o3);
    }

}
