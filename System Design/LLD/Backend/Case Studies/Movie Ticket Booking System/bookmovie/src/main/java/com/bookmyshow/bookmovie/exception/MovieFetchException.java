package com.bookmyshow.bookmovie.exception;

public class MovieFetchException extends RuntimeException {

    public MovieFetchException(String message) {
        super(message);
    }

    public MovieFetchException(String message, Throwable cause) {
        // NOTE: cause is the root cause of the error.
        super(message, cause);
    }

}
