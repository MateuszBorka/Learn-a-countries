package com.example.learnacountries.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Continent {
    private static final Map<String, String> continentMap = new HashMap<>();

    static {
        continentMap.put("AF", "Africa");
        continentMap.put("AN", "Antarctica");
        continentMap.put("AS", "Asia");
        continentMap.put("AU", "Australia");
        continentMap.put("EU", "Europe");
        continentMap.put("NA", "North America");
        continentMap.put("OC", "Oceania");
        continentMap.put("SA", "South America");
    }

    public static String getContinentName(String code) {
        return continentMap.get(code);
    }

    public static List<String> getAllContinentNames() {
        return new ArrayList<>(continentMap.values());
    }
}
