package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvokeDynamic {


    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(int.class, Object.class);
        MethodHandle bar = l.findVirtual(Foo.class, "bar", t);
        int ans = (int) bar.invokeExact(new Foo(), new Object());   //必须匹配返回类型
        bar.invoke(new Foo(), "123");
        MethodHandle newBar = MethodHandles.insertArguments(bar, 1, "456"); //设置默认参数
        newBar.invoke(new Foo());
        System.out.println(Integer.TYPE == int.class);
    }

}


class Foo {
    public int bar(Object o) {
        System.out.println(o);
        return 0;
    }
}


