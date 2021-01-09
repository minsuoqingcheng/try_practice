package service_breaker.core;

public class BreakOpenException extends RuntimeException {

    public BreakOpenException(String message) {
        super(message);
    }
}
