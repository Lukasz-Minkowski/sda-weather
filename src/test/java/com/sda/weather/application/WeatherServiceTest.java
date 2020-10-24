package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    WeatherService weatherService = new WeatherService();

    @Test
    void getWeather_whenCityIsLondonAndDaysToAddIs2_shouldReturnValues() {
        // when
        Weather response = weatherService.getWeather("London", 2);

        // then
        assertTrue(response.getHumidity() > 0);
        assertTrue(response.getTemperature() > -100);
        assertFalse(response.getWindDirection().isBlank());
        assertTrue(response.getPressure() > 0);
        assertTrue(response.getWindSpeed() >= 0);
    }

    @Test
    void getWeather_whenCityIsEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> weatherService.getWeather(" ", 2));
    }

    @Test
    void getWeather_whenDaysToAddIsWrong_shouldThrowException() {
        assertThrows(Exception.class, () -> weatherService.getWeather("Berlin", 10));
    }

}
