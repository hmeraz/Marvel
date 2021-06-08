package mx.com.Marvel.commons.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
