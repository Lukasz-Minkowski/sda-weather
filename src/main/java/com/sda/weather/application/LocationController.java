package com.sda.weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.exceptions.InternalServerException;

import java.util.ArrayList;
import java.util.List;

public class LocationController {

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) throws InternalServerException {
        Location location = locationService.addNewLocation(locationName, longitude, latitude, region, countryName);

        try {
            return objectMapper.writeValueAsString(location);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
    }

    public String readAllLocations() throws InternalServerException {
        List<Location> locations = locationService.readAllLocations();
        List<String> mappedLocations = new ArrayList<>();
        try {
            for (Location location : locations) {
                mappedLocations.add(objectMapper.writeValueAsString(location));
            }
        } catch (JsonProcessingException e) {
            throw new InternalServerException("HTTP 500 internal server error");
        }
        return mappedLocations.toString();
    }

    public String getWeatherValues() {
        // todo: move to WeatherController.java
        return null;
    }
}
