package com.sda.weather.application;

public class WeatherService {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    Weather getWeather(String cityName) {
        // todo use WeatherForecastClient and WeatherResponseMapper
        return new Weather();
    }
}
