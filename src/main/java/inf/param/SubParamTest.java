package inf.param;

public class SubParamTest implements ParamTest {

    /**
     * type must be same
     * @param a
     */
    @Override
    public void test(A a) {
        SubA s = (SubA) a;
    }
}
