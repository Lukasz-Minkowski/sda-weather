package com.sda.weather.application;

import com.sda.weather.exceptions.BadRequestException;

import java.util.List;

public class LocationService { //warstwa logiki biznesowej

    private final LocationRepository locationRepository = new LocationRepository();

    public Location addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) {
        if (locationName == null || locationName.isBlank()) {
            throw new BadRequestException("Lokalizacja nie może być pusta!");
        }
        if (longitude == null || longitude.isBlank()) {
            throw new BadRequestException("Długość geograficzna nie może być pusta!");
        }
        if (Integer.parseInt(longitude) < -180 || (Integer.parseInt(longitude) > 180)) {
            throw new BadRequestException("Nieprawidłowa wartość, proszę wpisać liczną z zakresu <-90, 90>");
        }
        if (latitude == null || latitude.isBlank()) {
            throw new BadRequestException("Szerokość geograficzna nie może być pusta!");
        }
        if (Integer.parseInt(latitude) < -90 || (Integer.parseInt(latitude) > 90)) {
            throw new BadRequestException("Nieprawidłowa wartość, proszę wpisać liczną z zakresu <-90, 90>");
        }
        if (countryName == null || countryName.isBlank()) {
            throw new BadRequestException("Nazwa kraju nie może być pusta");
        }

        Location location = new Location(locationName, longitude, latitude, region, countryName);
        Location savedLocation = locationRepository.saveNewLocation(location);

        return savedLocation;
    }

    public List<Location> readAllLocations() {
        return locationRepository.readAllLocations();
    }
}
