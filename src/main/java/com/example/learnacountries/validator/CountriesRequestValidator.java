package com.example.learnacountries.validator;

import com.example.learnacountries.dto.CountriesRequestDto;
import com.example.learnacountries.exception.InvalidRequestDataException;
import com.example.learnacountries.model.Continent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CountriesRequestValidator {

    @Value("${countries.retrieve.min-count}")
    private int min;

    @Value("${countries.retrieve.max-count}")
    private int max;

    public void validate(CountriesRequestDto request){

        if (request == null) {
            throw new InvalidRequestDataException("Request data is null");
        }
        else if (!Continent.getAllContinentNames().contains(request.getContinent())) {
            throw new InvalidRequestDataException("Wrong code of continent");
        }
        else if (request.getCount() > max){
            throw new InvalidRequestDataException("Count of countries should be " + max + " or less");
        }
        else if (request.getCount() < min){
            throw new InvalidRequestDataException("Count of countries should be " + min + " or more");
        }

    }

}
