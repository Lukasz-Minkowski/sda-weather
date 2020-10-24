package com.sda.weather.application;

public class WeatherService {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();
    private final WeatherResponseMapper weatherResponseMapper = new WeatherResponseMapper();
    private final WeatherRepository weatherRepository = new WeatherRepository();

    Weather getWeather(String cityName) {
        WeatherResponse.ListItem weatherList = weatherForecastClient.getWeather(cityName);
        Weather weather = weatherResponseMapper.mapToWeather(weatherList);
        return weatherRepository.saveNewWeatherForecast(weather);
    }
}
