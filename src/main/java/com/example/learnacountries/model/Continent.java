package com.example.learnacountries.model;


import com.example.learnacountries.exception.InvalidRequestDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Continent {
    private static final Map<String, String> continentMap = new HashMap<>();

    static {                                        // I would rather prefer to make Continent name a key of map,
                                                    // but task requires from me to create it this way
        continentMap.put("AF", "Africa");
        continentMap.put("AS", "Asia");
        continentMap.put("EU", "Europe");
        continentMap.put("NA", "North America");
        continentMap.put("OC", "Oceania");
        continentMap.put("SA", "South America");
    }

    public static String getContinentName(String code) {
        return continentMap.get(code);
    }

    public static String getContinentCode(String name) {
        for (Map.Entry<String, String> entry : continentMap.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        throw new InvalidRequestDataException("Validation error");
    }

    public static List<String> getAllContinentNames() {
        return new ArrayList<>(continentMap.values());
    }

    public static List<String> getAllContinentCodes() {
        return new ArrayList<>(continentMap.keySet());
    }
}
