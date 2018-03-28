package annotations;

import annotations.repeatable.ExceptionTest;
import annotations.repeatable.ExceptionTestContainer;

public class Sample {

    @Test
    public static void m1() {

    }

    @Test
    @ExceptionTest(NullPointerException.class)
    @ExceptionTest(RuntimeException.class)
    //@ExceptionTestContainer({@ExceptionTest(NullPointerException.class)})
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    @Test
    public void m4() {

    }

}
