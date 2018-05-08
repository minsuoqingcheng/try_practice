package question_every_day.consumer_and_supplier;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        ConsumerTest test = new ConsumerTest();
        Consumer<Student> consumer = (Student student) -> System.out.println(student.getId());
        Consumer<Student> consumer1 = consumer.andThen((Student student) -> System.out.println(student.getName()));
        Consumer<Student> function = test.printInfo(consumer1);
        Student student = new Student();
        student.setName("a");
        student.setId(10);
        function.accept(student);
    }

    private <T> Consumer<T>  printInfo(Consumer<T> consumer) {
        Consumer<T> printConsumer = System.out::println;
        return printConsumer.andThen(consumer);
    }

}
