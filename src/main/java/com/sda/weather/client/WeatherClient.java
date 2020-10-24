package com.sda.weather.client;

import com.sda.weather.application.LocationController;
import com.sda.weather.application.WeatherController;

import java.sql.SQLOutput;
import java.util.Scanner;

public class WeatherClient {

    private final LocationController locationController = new LocationController();
    private final WeatherController weatherController = new WeatherController();

    public void runClientInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Twoja aplikacja została uruchomiona");

        while (true) {
            System.out.println("Witaj w aplikacji pogodowej, co chcesz zrobić: ");
            System.out.println("1. Dodać nową lokalizację do bazy danych");
            System.out.println("2. Wyświetlić aktualnie dodane lokalizacje");
            System.out.println("3. Pobrać wartości pogodowe");
            System.out.println("4. Wyjść z aplikacji");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewEntry();
                    break;
                case 2:
                    readAllEntries();
                    break;
                case 3:
                    getWeather();
                    break;
                case 4:
                    System.out.println("Twoja aplikacja jest zamykana");
                    return;
            }
        }
    }

    private void getWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę lokalizacji: ");
        String cityName = scanner.nextLine();

        // todo develop a client interface to get data about a city
        weatherController.getWeatherValues(cityName);
    }

    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwę lokalizacji: ");
        String locationName = scanner.nextLine();
        System.out.print("Podaj długość geograficzną (liczba całk. z zakresu: -180(W) do 180(E): ");
        String longitude = scanner.nextLine();
        System.out.print("Podaj szerokość geograficzną (liczba. całk. z zakresu: -90(S) do 90(N): ");
        String latitude = scanner.nextLine();
        System.out.print("Podaj region: ");
        String region = scanner.nextLine();
        System.out.print("Podaj kraj: ");
        String countryName = scanner.nextLine();
        String response = locationController.addNewLocation(locationName, longitude, latitude, region, countryName);
        System.out.println("Nowy wpis został dodany: " + response + "\n");
    }

    private void readAllEntries() {
        String response = locationController.readAllLocations();
        response = response.replaceAll("\\[]", "\n")
                .replaceAll("\\{", "\n")
                .replaceAll("\\}", "")
                .replaceAll("\\]", "");

        System.out.println("Twoje wpisy: " + response);
    }

}
