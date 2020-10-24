package com.sda.weather.application;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue
    Long id;
    Float temperature;  //temperatura C
    Float pressure;     //ciśnienie
    Float humidity;     //wilgotność
    String windDirection; //kierunek wiatru
    Float windSpeed;    //prędkość wiatru

    public Weather(Float temperature, Float pressure, Float humidity, String windDirection, Float windSpeed) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }
}
