package cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before call: " + method);
        Object result = methodProxy.invokeSuper(o, objects);   //调用委托类
        System.out.println("after call: " + method);
        return result;
    }
}
