package com.sda.weather.application;

import java.util.List;

public class EntryController {

    private final EntryService entryService = new EntryService();

    public String addNewEntry(String locationName, String longitude, String latitude, String region, String countryName) {
        Entry entry = entryService.addNewEntry(locationName, longitude, latitude, region, countryName);
        return entry.toString();
    }

    public String readAllEntries() {
        List<Entry> entries = entryService.readAllEntries();
        return entries.toString();
    }

    public String getWeatherValues() {
        return null;
    }

}
