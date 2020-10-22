package com.sda.weather.application;

public class WeatherResponseMapper {

    public static Weather mapToWeather(WeatherResponse.ListItem listItem) {
        // todo create a Weather based on a data from WeatherResponse.ListItem
        return new Weather();
    }
}
