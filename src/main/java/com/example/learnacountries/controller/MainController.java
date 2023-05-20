package com.example.learnacountries.controller;

import com.example.learnacountries.model.Continent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public ResponseEntity<List<String>> home() {
        return ResponseEntity.ok(Continent.getAllContinentNames());
    }


}
