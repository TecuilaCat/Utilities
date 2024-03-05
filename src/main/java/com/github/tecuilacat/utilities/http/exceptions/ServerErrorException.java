package com.github.tecuilacat.utilities.http.exceptions;

/**
 * @author tecuilacat
 * @since 0.0.1
 */
public final class ServerErrorException extends HttpException {

    public ServerErrorException(String url) {
        super(url, 500);
    }

}
