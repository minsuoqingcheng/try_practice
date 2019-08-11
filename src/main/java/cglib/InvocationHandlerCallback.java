package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

public class InvocationHandlerCallback {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback((InvocationHandler) (o, method, objects) -> {
            if (method.getReturnType().equals(void.class)) {
                System.out.println("this method has no return");
            }
            return null;
        });
        Car car = (Car) enhancer.create();
        car.print();
    }

    static class Car {
        void print() {
            System.out.println("I am a car");
        }

    }

}
