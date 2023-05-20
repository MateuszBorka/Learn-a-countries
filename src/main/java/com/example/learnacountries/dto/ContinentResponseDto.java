package com.example.learnacountries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ContinentResponseDto {
    List<String> continentNames;
    int min;
    int max;
}