package com.sda.weather.application;

import lombok.Data;

import java.util.Scanner;

@Data
public class WeatherController {

    WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    public void getWeatherValues() {

        String cityName = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dla jakiego miasta, chcesz wyświetlić prognozę pogody: ");
        cityName = scanner.nextLine();
        weatherForecastClient.getWeather(cityName);

    }

}
