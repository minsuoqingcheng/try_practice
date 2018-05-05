package dynamic_invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokeHandler<T> implements InvocationHandler {

    private T target;

    public MyInvokeHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start!");
        Object result = method.invoke(target, args);
        System.out.println("proxy end!");
        return result;
    }


    public T getProxy() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        @SuppressWarnings("unchecked")
        T proxyInstance = (T) Proxy.newProxyInstance(classLoader, interfaces, this);
        return proxyInstance;
     }

}
