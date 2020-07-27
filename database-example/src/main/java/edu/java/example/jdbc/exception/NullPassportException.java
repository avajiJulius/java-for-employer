package edu.java.example.jdbc.exception;

/**
 * Throws this exception when list of passports is empty
 */

public class NullPassportException extends Exception {
    public NullPassportException() {
        super();
    }

    public NullPassportException(String message) {
        super(message);
    }

    public NullPassportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPassportException(Throwable cause) {
        super(cause);
    }
}
