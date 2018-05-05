package cglib;

import net.sf.cglib.proxy.Enhancer;

public class EnhancerUse {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StudentService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        StudentService studentService = (StudentService) enhancer.create();
        studentService.add();
        studentService.delete();
    }

}
