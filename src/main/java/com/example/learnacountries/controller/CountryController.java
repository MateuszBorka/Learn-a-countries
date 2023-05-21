package com.example.learnacountries.controller;


import com.example.learnacountries.domain.Country;
import com.example.learnacountries.dto.CountriesRequestDto;
import com.example.learnacountries.validator.CountriesRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountriesRequestValidator validator;

    @PostMapping("/")
    public CollectionModel<EntityModel<Country>> getRandomCountriesFromContinent(
            @RequestBody CountriesRequestDto request){
        validator.validate(request);

        return null;
    }


}