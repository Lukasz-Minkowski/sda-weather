package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationServiceTest {

    private final LocationService locationService = new LocationService();

    @Test
    void addNewLocation_whenCityInEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation("", "40", "50", "region", "country"));
    }

    @Test
    void addNewLocation_whenLongitudeIsAbove180_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation("London", "181", "50", "region", "country"));
    }
}
