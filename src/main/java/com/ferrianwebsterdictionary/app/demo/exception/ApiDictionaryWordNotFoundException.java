package com.ferrianwebsterdictionary.app.demo.exception;

public class ApiDictionaryWordNotFoundException extends RuntimeException {
    public ApiDictionaryWordNotFoundException(String message) {
        super(message);
    }
}
