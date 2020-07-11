package test;

public class ClassTest {

    public static void main(String[] args) {
        Object[] os = new Object[]{Long.class, Integer.class};
        Class<?>[] classes = new Class[os.length];
        for (int i = 0; i < os.length; i++) {
            classes[i] = (Class<?>) os[i];
        }
        System.out.println(classes.length);
    }

}
