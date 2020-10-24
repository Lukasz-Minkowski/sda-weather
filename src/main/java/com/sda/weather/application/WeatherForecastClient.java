package com.sda.weather.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.exceptions.BadGatawayException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;

public class WeatherForecastClient { //klasa odpowiedzialna za pobieranie danych z serwisu pogodowego

    private final String API_KEY = "486f4c8ae5c71bb0929a2a801c1b6d07";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherForecastClient() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //jeśli w czasie deserializacji danych pobranych z serwisu
        //okaże się, że nie są pobrane wszystkie, czyli 1 do 1,
        //to wtedy poleciałby exceptios, a ten zapis, powoduje,
        //że exception nie poleci
        objectMapper.findAndRegisterModules();
    }

    public WeatherResponse.ListItem getWeather(String cityName) {
        // todo K -> C
        String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s", cityName, API_KEY);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);
            List<WeatherResponse.ListItem> list = weatherResponse.getList();

            return list.stream()
                    .filter(dt -> dt.getDt_txt().equals(LocalDate.now().plusDays(1) + " 12:00:00")) // todo parametrize days CTRL + ALT + P
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("...")); // todo create your own exception
        } catch (Exception e) {
            System.out.println("Nieudana próba połączenia z serwisem: " + e.getMessage());
            throw new BadGatawayException("Nieudana próba połączenia z serwisem, 502");
        }
    }
}
