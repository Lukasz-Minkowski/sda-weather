package com.sda.weather.application;

import lombok.Data;

@Data
public class WeatherController {

    WeatherService weatherController = new WeatherService();

    public String getWeatherValues(String cityName) {
        // todo move to the Client class
//        String cityName = "";
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Dla jakiego miasta, chcesz wyświetlić prognozę pogody: ");
//        cityName = scanner.nextLine();

        // todo use WeatherService to get information about a weather
        // todo use ObjectMapper to map a Weather to String
        return "";
    }
}
