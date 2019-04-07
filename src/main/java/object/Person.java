package object;

import java.util.Arrays;

public class Person implements Cloneable {

    private String name;
    /**
     * 这边数组也是一个对象引用，因为浅拷贝的原因，直接拷贝引用（对象在堆中的首地址）
     */
    private int[] ages;
    private Integer test;

    public Person(String name, int[] ages, Integer test) {
        this.name = name;
        this.ages = ages;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAges() {
        return ages;
    }

    public void setAges(int[] ages) {
        this.ages = ages;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return Arrays.toString(ages) + ":" + test;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person = new Person("1", new int[]{1, 2}, 78889);
        Person p2 = (Person) person.clone();
        person.ages[0] = 3;
        person.setTest(11);
        System.out.println(person.ages == p2.ages);
        System.out.println(person.toString());
        System.out.println(p2.toString());

        System.out.println("==============");
        Person[] persons = new Person[2];
        persons[0] = new Person("1", new int[]{1, 2}, 10);
        persons[1] = new Person("2", new int[]{3, 4}, 10);
        Person[] peple = persons.clone();
        System.out.println("test: " + (persons == peple));
        for (Person p : persons) {
            System.out.println(p.hashCode());
            System.out.println(p.toString());
        }
        System.out.println("==========");
        for (Person p : peple) {
            System.out.println(p.hashCode());
            System.out.println(p.toString());
        }
        System.out.println(persons[0] == peple[0]);
    }


}
