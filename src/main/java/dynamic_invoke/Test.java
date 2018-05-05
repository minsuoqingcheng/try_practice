package dynamic_invoke;

public class Test {

    public static void main(String[] args) {
        Service service = new UserServiceImpl();
        MyInvokeHandler<Service> invokeHandler = new MyInvokeHandler<>(service);
        Service proxyService = invokeHandler.getProxy();
        proxyService.handle();
    }

}
