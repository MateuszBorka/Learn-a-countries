package com.example.learnacountries.controller;

import com.example.learnacountries.dto.ContinentResponseDto;
import com.example.learnacountries.model.Continent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Value("${countries.retrieve.min-count}")
    private int min;

    @Value("${countries.retrieve.max-count}")
    private int max;

    @GetMapping("/")
    public ResponseEntity<ContinentResponseDto> home() {
        List<String> continentNames = Continent.getAllContinentNames();
        ContinentResponseDto responseData = new ContinentResponseDto(continentNames, min, max);
        return ResponseEntity.ok(responseData);
    }


}

