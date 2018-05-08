package question_every_day.enum_test;

public enum Father {


    A;

    //class byte code
    /**
     *
     * public final enum grade4/enum_test/Father extends java/lang/Enum
     *
     * 因为枚举类编译后声明成final，所以无法被继承
     *
     */

    //static和transient变量无法被序列化

    //通过readResolve()方法可以控制返回的反序列化对象


}