package jvm;

public class InternEqualTest {

    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("vaa").toString();
        System.out.println(str2.intern() == str2);

        String str3 = "计算机软件";
        System.out.println(str3 == str1);

        String str4 = "javaa";
        System.out.println(str4 == str2);


        String test3 = "test";
        String test1 = new String("test");
        String test2 = new String("test");
        String test4 = test1.intern();


        System.out.println(test1 == test2);
        System.out.println(test3 == test1);
        System.out.println(test3 == test2);
        System.out.println(test1 == test4);
        System.out.println(test4 == test3);

    }

}
