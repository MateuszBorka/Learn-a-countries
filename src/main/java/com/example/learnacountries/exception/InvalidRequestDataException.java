package com.example.learnacountries.exception;

public class InvalidRequestDataException extends RuntimeException {
    public InvalidRequestDataException(String message) {
        super(message);
    }
}
