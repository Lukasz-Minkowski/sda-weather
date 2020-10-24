package com.sda.weather.application;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherResponse {

    List<ListItem> list = new ArrayList<>();

    @Data
    public static class ListItem{

        Main main; //klasa wewnętrzna - abby odwzorować zagnieżdżenia JSONa, możemy tto również zrobić w osobnych klasach
        Wind wind; //klasa wewnętrzna
        String dt_txt;

        @Data
        public static class Main{
            Float temp;
            Float pressure;
            Float humidity;
        }

        @Data
        public static class Wind{
            Float speed;
            Float deg;
        }
    }
}
