package com.bookmyshow.bookmovie.exception;

public class MovieServiceException extends RuntimeException {

    public MovieServiceException(String message) {
        super(message);
    }

    public MovieServiceException(String message, Throwable cause) {
        // NOTE: cause is the root cause of the error.
        super(message, cause);
    }

}
