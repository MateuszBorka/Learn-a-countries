package com.example.learnacountries.service;

import com.example.learnacountries.domain.Country;
import com.example.learnacountries.dto.CountriesRequestDto;
import com.example.learnacountries.model.Continent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CountriesMainService {

    private final CountriesGraphQLService countriesService;
    private final RestCountriesService restService;

    public List<Country> generateCountriesList(CountriesRequestDto request) {
        List<String> countriesNames = countriesService.getRandomCountriesNamesFromContinent(
                Continent.getContinentCode(request.getContinent()), request.getCount()
        );
        List<Country> countriesWithDetails = restService.getCountriesDetails(countriesNames);
        return countriesWithDetails;
    }
}
