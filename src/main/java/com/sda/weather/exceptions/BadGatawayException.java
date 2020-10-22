package com.sda.weather.exceptions;

public class BadGatawayException extends RuntimeException {

    public BadGatawayException(String message){
        super(message);
    }
}
