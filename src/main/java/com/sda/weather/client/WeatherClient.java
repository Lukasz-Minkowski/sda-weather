package com.sda.weather.client;

import java.util.Scanner;

public class WeatherClient {

    private final EntryController entryController = new EntryController();

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
                    getWeatherValues();
                    break;
                case 0:
                    System.out.println("Twoja aplikacja jest zamykana");
                    return;

            }
        }
    }

    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwę lokalizacji: ");
        String locationName = scanner.nextLine();
        System.out.println("Podaj szerokość geograficzną: ");


    }

    private void readAllEntries() {

    }

    private void getWeatherValues() {

    }

}
