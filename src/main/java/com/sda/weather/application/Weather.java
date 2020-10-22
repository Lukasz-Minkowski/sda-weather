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
    Integer temperature;  //temperatura C
    Integer pressure;     //ciśnienie
    Integer humidity;     //wilgotność
    String windDirection; //kierunek wiatru
    Integer windSpeed;    //prędkość wiatru

    public Weather(Integer temperature, Integer pressure, Integer humidity, String windDirection, Integer windSpeed) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }
}
