package ro.devdepot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ExceptionResponse {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ExceptionResponse(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
