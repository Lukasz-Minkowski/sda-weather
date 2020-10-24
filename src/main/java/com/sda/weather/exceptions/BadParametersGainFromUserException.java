package com.sda.weather.exceptions;

public class BadParametersGainFromUserException extends RuntimeException {

    public BadParametersGainFromUserException(String message) {
        super(message);
    }
}