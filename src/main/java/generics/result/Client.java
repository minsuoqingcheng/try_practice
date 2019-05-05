package generics.result;

import java.util.Arrays;
import java.util.Collections;

public class Client {

    public static void main(String[] args) {

        ResultListVO<Integer> resultVO = new ResultListVO<>(0, Collections.singletonList(1));
        ResultListVO<Integer> resultVOData = new ResultListVO<>(0, Arrays.asList(1, 2, 3));

        System.out.println(resultVO);
        System.out.println(resultVOData);

    }

}
