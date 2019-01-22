package java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStream {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1, 2, 3).boxed().mapToInt(Integer::intValue);

        IntStream rangeStram = IntStream.rangeClosed(1, 100);

        /**
         * IntStream map 只能返回IntStream
         */
        List<double[]> data = IntStream.rangeClosed(1, 100).boxed()
                                                          //.boxed().map()
                .flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)).collect(Collectors.toList());

    }

}
