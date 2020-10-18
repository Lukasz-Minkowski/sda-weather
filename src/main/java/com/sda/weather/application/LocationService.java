package com.sda.weather.application;

import java.util.List;

public class LocationService {

    private final LocationRepository locationRepository = new LocationRepository();

    public Location addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) {
        if (locationName == null || locationName.isEmpty()) {
            throw new RuntimeException("Lokalizacja nie może być pusta!");
        }
        if (longitude == null || longitude.isEmpty()) {
            throw new RuntimeException("Długość geograficzna nie może być pusta!");
        }
        if (Integer.parseInt(longitude) < -180 || (Integer.parseInt(longitude) > 180)) {
            throw new RuntimeException("Nieprawidłowa wartość, proszę wpisać liczną z zakresu <-90, 90>");
        }
        if (latitude == null || latitude.isEmpty()) {
            throw new RuntimeException("Szerokość geograficzna nie może być pusta!");
        }
        if (Integer.parseInt(latitude) < -90 || (Integer.parseInt(latitude) > 90)) {
            throw new RuntimeException("Nieprawidłowa wartość, proszę wpisać liczną z zakresu <-90, 90>");
        }
        if (countryName == null || countryName.isEmpty()) {
            throw new RuntimeException("Nazwa kraju nie może być pusta");
        }

        Location location = new Location(locationName, longitude, latitude, region, countryName);
        Location savedLocation = locationRepository.saveNewLocation(location);

        return savedLocation;
    }

    public List<Location> readAllLocations() {
        return locationRepository.readAllLocations();
    }
}