package obeject;

public class ObjectCloneTest implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectCloneTest test = new ObjectCloneTest();
        test.clone();
    }

    @Override
    protected ObjectCloneTest clone() throws CloneNotSupportedException {
        return new ObjectCloneTest();
    }
}
