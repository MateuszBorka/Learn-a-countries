package com.example.learnacountries.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CountriesGraphQLTest {     //This class is supposed to test CountriesGraphQL and JsonParser classes

    @Test
    public void getRandomCountriesFromContinentNamesTest(){

        List<String> countriesInEurope = Arrays.asList(
                "Andorra", "Albania", "Austria", "Åland", "Bosnia and Herzegovina", "Belgium", "Bulgaria",
                "Belarus", "Switzerland", "Cyprus", "Czech Republic", "Germany", "Denmark", "Estonia", "Spain",
                "Finland", "Faroe Islands", "France", "United Kingdom", "Guernsey", "Gibraltar", "Greece",
                "Croatia", "Hungary", "Ireland", "Isle of Man", "Iceland", "Italy", "Jersey", "Liechtenstein",
                "Lithuania", "Luxembourg", "Latvia", "Monaco", "Moldova", "Montenegro", "North Macedonia",
                "Malta", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Serbia", "Russia",
                "Sweden", "Slovenia", "Svalbard and Jan Mayen", "Slovakia", "San Marino", "Ukraine",
                "Vatican City", "Kosovo"
        );

        List<String> answer = CountriesGraphQL.getRandomCountriesFromContinentNames("EU", 5);
        List<String> answer2 = CountriesGraphQL.getRandomCountriesFromContinentNames("EU", 5);

        assertEquals(5, answer.size());             //size of answer should be the same as in call
        assertTrue(countriesInEurope.containsAll(answer));  //answer should be sublist of countriesInEurope
        assertNotEquals(answer, answer2);                   //result of call should return random countries

    }
}
