package com.example.learnacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.learnacountries") // Specify the base package(s) to scan for components
public class LearnACountriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnACountriesApplication.class, args);
    }

}
