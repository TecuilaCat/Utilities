package com.github.tecuilacat.utilities.http.exceptions;

/**
 * @author tecuilacat
 * @since 0.0.1
 */
public sealed class HttpException extends Exception permits UnknownErrorException,
                                                            EndpointNotFoundException,
                                                            ServerErrorException,
                                                            NotAuthenticatedException,
                                                            ForbiddenException {

    public HttpException(String url, int responseCode) {
        super("Encountered " + responseCode + " error trying to reaching: " + url);
    }

}
