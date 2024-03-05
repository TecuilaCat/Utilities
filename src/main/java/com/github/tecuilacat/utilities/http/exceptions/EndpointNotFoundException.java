package com.github.tecuilacat.utilities.http.exceptions;

/**
 * @author tecuilacat
 * @since 0.0.1
 */
public final class EndpointNotFoundException extends HttpException {

    public EndpointNotFoundException(String url) {
        super(url, 404);
    }

}
