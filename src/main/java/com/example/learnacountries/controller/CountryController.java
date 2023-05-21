package com.example.learnacountries.controller;


import com.example.learnacountries.domain.Country;
import com.example.learnacountries.dto.CountriesRequestDto;
import com.example.learnacountries.service.CountriesMainService;
import com.example.learnacountries.validator.CountriesRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountriesRequestValidator validator;
    private final CountriesMainService service;


    @PostMapping("/")
    public ResponseEntity<List<Country>> getRandomCountriesFromContinent(
            @RequestBody CountriesRequestDto request) {
        validator.validate(request);
        List<Country> countries = service.generateCountriesList(request);
        return ResponseEntity.ok(countries);
    }


}