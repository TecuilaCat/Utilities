package com.github.tecuilacat.utilities.exceptions;

public abstract sealed class UtilitiesException extends Exception permits UtilitiesEmptyListException {

    public UtilitiesException() {
        super();
    }

    public UtilitiesException(String message) {
        super(message);
    }

    public UtilitiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilitiesException(Throwable cause) {
        super(cause);
    }

    protected UtilitiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
