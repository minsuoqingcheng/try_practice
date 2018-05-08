package question_every_day.consumer_and_supplier;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

        SupplierTest test = new SupplierTest();
        Person person = test.getEntity(Person::new);
        System.out.println(person);
        Student student = test.getEntity(Student::new);
        System.out.println(student);
    }

    private <T> T getEntity(Supplier<T> supplier) {
        return supplier.get();
    }

}
