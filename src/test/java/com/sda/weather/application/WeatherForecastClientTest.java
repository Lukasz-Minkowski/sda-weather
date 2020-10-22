package com.sda.weather.application;

import org.junit.jupiter.api.Test;

public class WeatherForecastClientTest {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    @Test
    void test() {       // todo name me, develop me
        WeatherResponse.ListItem listItem = weatherForecastClient.getWeather("London");
        System.out.println(listItem);
    }
}
