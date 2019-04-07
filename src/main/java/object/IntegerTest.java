package object;

import java.util.Arrays;

public class IntegerTest {

    public static void main(String[] args) {
        /**
         * 数组本身就是一个对象，它也符合copy()的规则（浅拷贝）
         * 如果是primitive type或者是对应的包装类型，是拷贝纸
         * 如果是自定义的对象，就是浅拷贝
         *
         */
        Integer[] a = new Integer[]{10000, 20000, 30000};
        Integer[] b = a.clone();
        System.out.println(a==b);
        a[0] = 4;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        int[] test = new int[]{1, 2, 3};
        int[] copy = test.clone();
        test[0] = 4;
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(copy));


        System.out.println("==================");
        Long[] longs = new Long[]{3L, 4L, 5L};
        Long[] cloned = longs.clone();
        longs[0] = 6L;
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(cloned));
    }

}
