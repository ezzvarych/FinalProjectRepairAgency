package com.cources.finalProject.exceptions;

/**
 * Each SQLException will be catched to throw this RuntimeException
 */
public class DBRequestException extends RuntimeException {

    public DBRequestException() {
        super();
    }

    public DBRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBRequestException(Throwable cause) {
        super(cause);
    }

    public DBRequestException(String message) {
        super(message);
    }
}
