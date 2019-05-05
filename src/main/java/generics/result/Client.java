package generics.result;

import java.util.Arrays;
import java.util.Collections;

public class Client {

    public static void main(String[] args) {

        ResultVO<Integer> resultVO = new ResultVO<>(0, Collections.singletonList(1));
        ResultVO<Integer> resultVOData = new ResultVO<>(0, Arrays.asList(1, 2, 3));

        System.out.println(resultVO);
        System.out.println(resultVOData);

    }

}
