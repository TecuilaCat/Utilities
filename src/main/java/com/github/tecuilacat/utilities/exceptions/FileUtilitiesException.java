package com.github.tecuilacat.utilities.exceptions;

public class FileUtilitiesException extends Exception {

    public FileUtilitiesException() {
    }

    public FileUtilitiesException(String message) {
        super(message);
    }

    public FileUtilitiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUtilitiesException(Throwable cause) {
        super(cause);
    }

    public FileUtilitiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
