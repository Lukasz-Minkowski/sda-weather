package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherForecastClientTest {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    @Test
    void getWeatherAsListWhenCityisLondonAndDaysToAddis1() {
        // when
        WeatherResponse.ListItem listItem = weatherForecastClient.getWeather("London", 1);

        // then
        assertTrue(listItem.main.temp > -100);
        assertTrue(listItem.main.pressure > 0);
        assertTrue(listItem.main.humidity > 0);
        assertFalse(listItem.wind.speed < 0);
    }

    @Test
    void getWeatherAsList_whenCityIsEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> weatherForecastClient.getWeather(" ", 2));
    }


}
