package com.github.tecuilacat.utilities.http.exceptions;

public final class NotAuthenticatedException extends HttpException {
    public NotAuthenticatedException(String url) {
        super(url, 401);
    }
}
