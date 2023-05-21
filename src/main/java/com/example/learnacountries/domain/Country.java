package com.example.learnacountries.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    String official;
    String capital;
    int population;
    List<CountryCurrency> currencies = new ArrayList<>();
    String subregion;
    List<String> languages = new ArrayList<>();

    boolean isPresentInRestDatabase;

    public void addCurrency(CountryCurrency currency){
        currencies.add(currency);
    }

    public void addLanguage(String language){
        languages.add(language);
    }






}
