package order;

import lombok.Data;

@Data
public class ErrorCodeException extends RuntimeException {

    private int code;

    public ErrorCodeException(int code) {
    }
}
