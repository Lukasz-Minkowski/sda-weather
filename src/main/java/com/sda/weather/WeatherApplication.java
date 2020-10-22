package com.sda.weather;

import com.sda.weather.client.WeatherClient;

public class WeatherApplication {

    public static void main(String[] args) {
        WeatherClient weatherClient = new WeatherClient();
        weatherClient.runClientInterface();
    }
}
