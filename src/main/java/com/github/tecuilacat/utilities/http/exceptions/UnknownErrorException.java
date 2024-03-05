package com.github.tecuilacat.utilities.http.exceptions;

/**
 * @author tecuilacat
 * @since 0.0.1
 */
public final class UnknownErrorException extends HttpException {
    public UnknownErrorException(String url) {
        super(url, 0);
    }
}
