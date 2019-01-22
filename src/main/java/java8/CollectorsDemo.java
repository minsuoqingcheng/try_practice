package java8;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class CollectorsDemo {

    public static void main(String[] args) {

        IntSummaryStatistics summaryStatistics = new IntSummaryStatistics();
        double average = summaryStatistics.getAverage();
        int max = summaryStatistics.getMax();

        // Collectors.counting() -> reducing(0L, e -> 1L, Long::sum);
//        Collectors.reducing()

        ArrayList<Person> persons = Stream.of(new Person(1, "a")).collect(toCollection(ArrayList::new));

        Map<Integer, List<Person>> collect = persons.stream().collect(groupingBy(Person::getAge));
        List<Person> data = collect.getOrDefault(0, new ArrayList<>());
        System.out.println(data);

    }




}


class Person {

    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
