package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeatherServiceTest {

    WeatherService weatherService = new WeatherService();

    @Test
    void getWeather_whenCityIsLondon_shouldReturnValues() {
        // when
        Weather response = weatherService.getWeather("London");

        // then
        assertTrue(response.getHumidity() > 0);
        assertTrue(response.getTemperature() > -100);
        assertFalse(response.getWindDirection().isBlank());
        assertTrue(response.getPressure() > 0);
        assertTrue(response.getWindSpeed() >= 0);
    }
}
