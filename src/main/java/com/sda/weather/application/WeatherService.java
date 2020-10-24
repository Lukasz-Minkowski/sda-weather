package com.sda.weather.application;

public class WeatherService {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();
    private final WeatherResponseMapper weatherResponseMapper = new WeatherResponseMapper();
    private final WeatherRepository weatherRepository = new WeatherRepository();

    Weather getWeather(String cityName, Integer daysToAdd) {
        WeatherResponse.ListItem weatherList = weatherForecastClient.getWeather(cityName,daysToAdd);
        Weather weather = weatherResponseMapper.mapToWeather(weatherList);
        return weatherRepository.saveNewWeatherForecast(weather);
    }
}
