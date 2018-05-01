package dynamic_call;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleDynamic {

    public static void main(String[] args) throws Throwable {

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findStatic(
                MethodHandleDynamic.class,
                "hello",
                MethodType.methodType(void.class, String.class)
        );
        methodHandle.invokeExact("ketty");
    }


    static void hello(String name) {
        System.out.println("hello："+name);
    }

}
