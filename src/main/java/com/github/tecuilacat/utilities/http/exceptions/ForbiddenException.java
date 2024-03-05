package com.github.tecuilacat.utilities.http.exceptions;

public final class ForbiddenException extends HttpException {
    public ForbiddenException(String url) {
        super(url, 403);
    }
}
