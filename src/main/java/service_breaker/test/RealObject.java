package service_breaker.test;

public class RealObject {

    public int call(int i) {
        if (i <= 2 || i >= 8) {
            return i;
        } else {
            throw new IllegalArgumentException("i is invalid");
        }
    }

}
