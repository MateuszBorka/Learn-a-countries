package com.example.learnacountries.service;

import com.example.learnacountries.domain.Country;
import com.example.learnacountries.domain.CountryCurrency;
import com.example.learnacountries.exception.InvalidApiUrlException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class RestCountriesService {


    @Value("${restCountriesUrl}")
    private String apiUrl;

    public List<Country> getCountriesDetails(List<String> countriesNames) {
        List<Country> countriesWithDetails = new ArrayList<>();
        for (String countryName : countriesNames) {
            countriesWithDetails.add(getCountryDetails(countryName));
        }
        return countriesWithDetails;
    }

    public Country getCountryDetails(String country) {

        String restCountriesUrl = apiUrl + country;
        Country countryWithDetails = new Country();
        try {
            String jsonResponse;
            try {
                jsonResponse = getJsonResponse(restCountriesUrl);
            } catch (IllegalArgumentException e) {       //There is no information about country
                countryWithDetails.setPresentInRestDatabase(false);
                countryWithDetails.setOfficial(country);
                return countryWithDetails;
            }
            countryWithDetails.setPresentInRestDatabase(true);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            countryWithDetails.setOfficial(rootNode.get(0).get("name").get("official").asText());
            countryWithDetails.setCapital(rootNode.get(0).get("capital").get(0).asText());
            countryWithDetails.setPopulation(rootNode.get(0).get("population").asInt());
            countryWithDetails.setSubregion(rootNode.get(0).get("subregion").asText());

            JsonNode currenciesNode = rootNode.get(0).get("currencies");
            for (JsonNode currencyNode : currenciesNode) {
                countryWithDetails.addCurrency(
                        new CountryCurrency(currencyNode.get("name").asText(), currencyNode.get("symbol").asText())
                );
            }

            JsonNode languagesNode = rootNode.get(0).get("languages");
            for (JsonNode language : languagesNode) {
                countryWithDetails.addLanguage(language.asText());
            }
        } catch (IOException e) {
            throw new InvalidApiUrlException(restCountriesUrl);
        }
        return countryWithDetails;
    }

    public String getJsonResponse(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity);
        } else {
            throw new InvalidApiUrlException(url);
        }
    }


//    public static void main(String[] args) {
//        ArrayList<Country> countries = getCountriesDetails();
//    }


}
