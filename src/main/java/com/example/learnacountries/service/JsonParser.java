package com.example.learnacountries.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<String> getNamesFromJson(String request) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> countryNames = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(request);
            JsonNode countriesNode = root.path("data").path("continent").path("countries");


            for (JsonNode countryNode : countriesNode) {
                String name = countryNode.path("name").asText();
                countryNames.add(name);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return countryNames;
    }
}
