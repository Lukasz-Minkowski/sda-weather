package com.sda.weather.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String locationName;
    String longitude;
    String latitude;
    String region;
    String countryName;

    public Location(String locationName, String longitude, String latitude, String region, String countryName) {
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.region = region;
        this.countryName = countryName;
    }
}
