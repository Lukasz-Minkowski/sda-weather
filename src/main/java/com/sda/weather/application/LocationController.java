package com.sda.weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationController {

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addNewLocation(String locationName, String longitude, String latitude, String region, String countryName) {
        Location location = locationService.addNewLocation(locationName, longitude, latitude, region, countryName);

        try {
            return objectMapper.writeValueAsString(location);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("...");  // todo: create your own Exception eg. InternalServerException = 500
        }
    }

    public String readAllEntries() {
        List<Location> entries = locationService.readAllEntries();
        return entries.toString();  // todo: use objectMapper
    }

    public String getWeatherValues() {
        // todo: move to WeatherController.java
        return null;
    }
}
