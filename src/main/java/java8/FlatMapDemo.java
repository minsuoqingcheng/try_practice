package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(p -> System.out.println(p[0]+" "+p[1]));


        String test = "this is my test";
        Stream.of(test.split(" ")).flatMap(s -> s.chars().boxed()).forEach(
                i -> {
                    System.out.print((char)i.intValue());
                    System.out.print(" ");
                }
        );
    }

}
