package com.example.learnacountries.exception;

public class InvalidApiUrlException extends RuntimeException {
    public InvalidApiUrlException(String url) {
        super("Error creating URL: " + url);
    }
}
