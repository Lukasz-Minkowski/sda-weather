package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationServiceTest {

    private final LocationService locationService = new LocationService();

    @Test
    void addNewLocation_shouldReturnNewLocation(){
        // when
        Location result = locationService.addNewLocation("city", "1", "0", "region", "country");

        // then
        assertEquals(result.getLocationName(), "city");
        assertEquals(result.getRegion(), "region");
        assertEquals(result.getCountryName(), "country");
        assertEquals(result.getLongitude(), "1");
        assertEquals(result.getLatitude(), "0");
    }

    @Test
    void addNewLocation_whenRegionNameIsEmpty_shouldReturnNewLocation() {
        // when
        Location result = locationService.addNewLocation("city", "40", "50", "", "country");

        // then
        assertEquals(result.getLocationName(), "city");
        assertEquals(result.getRegion(), "");
        assertEquals(result.getCountryName(), "country");
        assertEquals(result.getLongitude(), "40");
        assertEquals(result.getLatitude(), "50");
    }

    @Test
    void addNewLocation_whenCityIsEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation(" ", "40", "50", "region", "country"));

        // todo: isEmpty vs isBlank
    }

    @Test
    void addNewLocation_whenLongitudeIsAbove180_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation("London", "181", "50", "region", "country"));
    }

    @Test
    void addNewLocation_whenLongitudeIsEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation("London", " ", "50", "region", "country"));
    }

    @Test
    void addNewLocation_whenLatitudeIsAbove90_shouldThrowException(){
        assertThrows(Exception.class, () -> locationService.addNewLocation("Berlin", "150", "95", "region", "country"));
    }

    @Test
    void addNewLocation_whenLatitudeIsEmpty_shouldThrowException(){
        assertThrows(Exception.class, () -> locationService.addNewLocation("Berlin", "150", " ", "region", "country"));
    }

    @Test
    void addNewLocation_whenCountryNameInEmpty_shouldThrowException() {
        assertThrows(Exception.class, () -> locationService.addNewLocation("Berlin", "40", "50", "region", " "));
    }

}
