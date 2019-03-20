package generics;

import generics.test.Animal;
import generics.test.Cat;

import java.util.ArrayList;
import java.util.List;

public class SuperGenericTest {

    public static void main(String[] args) {

        List<? super Animal> list = new ArrayList<>();
        list.add(new Animal());
        list.add(new Cat());
        //list.add(new Object()); //编译报错，只能添加Animal或者它的子类

        List<Animal> covert = (List<Animal>) list;
        System.out.println(covert.get(0));
        System.out.println(covert.get(1));

        //List<Cat> convert = (List<Cat>) list;  编译报错，只可以强转成Animal
    }

}
