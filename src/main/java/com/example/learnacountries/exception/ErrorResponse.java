package com.example.learnacountries.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;


}
