package com.sda.weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.exceptions.InternalServerException;
import lombok.Data;

@Data
public class WeatherController {

    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getWeatherValues(String cityName, Integer daysToAdd) {
        Weather weather = weatherService.getWeather(cityName, daysToAdd);
        try {
            return objectMapper.writeValueAsString(weather);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }
}
