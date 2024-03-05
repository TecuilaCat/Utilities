package com.github.tecuilacat.utilities.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tecuilacat.utilities.http.exceptions.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tecuilacat
 * @since v0.0.1
 */
public class RestUtils {

    public static <T> T get(String url, Class<T> type) throws IOException, HttpException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStream, type);
        } else {
            throw determineError(connection.getResponseCode(), url);
        }
    }

    public static String getAsJsonString(String url) throws HttpException, IOException {
        LinkedHashMap response = get(url, LinkedHashMap.class);
        return new Gson().toJson(response, Map.class);
    }

    public static JsonObject getAsJsonObject(String url) throws IOException, HttpException {
        return new JsonParser().parse(getAsJsonString(url)).getAsJsonObject();
    }

    /**
     * Determines which HttpException is fitting for which error code
     * @param responseCode Responsecode from the connection
     * @param url Url of the target endpoint
     * @return Fitting HttpException
     * @see HttpException
     */
    private static HttpException determineError(int responseCode, String url) {
        return switch (responseCode) {
            case 401 -> new NotAuthenticatedException(url);
            case 403 -> new ForbiddenException(url);
            case 404 -> new EndpointNotFoundException(url);
            case 500 -> new ServerErrorException(url);
            default -> new UnknownErrorException(url);
        };
    }

}
