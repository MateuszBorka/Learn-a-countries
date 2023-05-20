package com.example.learnacountries.service;

import com.example.learnacountries.exception.InvalidApiUrlException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Component
public class CountriesGraphQL {

    //@Value("${graphqlApiUrl}")
    private static String apiUrl = "https://countries.trevorblades.com/graphql";

    public static List<String> getRandomCountriesNamesFromContinent(String continent, int count){


        List<String> allCountriesFromContinent;
        String requestBody = "{\"query\": \"query { continent(code: \\\"" + continent + "\\\") { countries { name } } }\"}";

        URL url;
        HttpURLConnection connection;

        try {
            url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
        } catch (IOException e) {
            throw new InvalidApiUrlException(apiUrl);
        }

        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");


        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] requestBodyBytes = requestBody.getBytes();
            outputStream.write(requestBodyBytes);
        } catch (IOException e) {
            throw new InvalidApiUrlException(apiUrl);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            throw new InvalidApiUrlException(apiUrl);
        }

        connection.disconnect();

        allCountriesFromContinent = JsonParser.getNamesFromJson(response.toString());
        Collections.shuffle(allCountriesFromContinent);
        return allCountriesFromContinent.subList(0, count);


    }
}
