package com.sda.weather.application;

import java.util.List;

public class EntryService {

    private final EntryRepository entryRepository = new EntryRepository();

    public Entry addNewEntry(String locationName, String longitude, String latitude, String region, String countryName) {
        if (locationName == null || locationName.isEmpty()) {
            throw new RuntimeException("Lokalizacja nie może być pusta!");
        }
        if (longitude == null || longitude.isEmpty()) {
            throw new RuntimeException("Długość geograficzna nie może być pusta!");
        }
        if (latitude == null || latitude.isEmpty()) {
            throw new RuntimeException("Szerokość geograficzna nie może być pusta!");
        }
        if (countryName == null || countryName.isEmpty()) {
            throw new RuntimeException("Nazwa kraju nie może być pusta");
        }

        Entry entry = new Entry(locationName, longitude, latitude, region, countryName);
        Entry savedEntry = entryRepository.saveNewEntry(entry);

        return savedEntry;
    }

    public List<Entry> readAllEntries() {
        return entryRepository.readAllEntries();
    }
}