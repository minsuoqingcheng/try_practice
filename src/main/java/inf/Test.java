package inf;

public class Test {

    public static void main(String[] args) {
        InterfaceObject interfaceObject = new InterfaceObject() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        };
        //class java.lang.Object
        System.out.println(interfaceObject.getClass().getSuperclass());
    }

}
