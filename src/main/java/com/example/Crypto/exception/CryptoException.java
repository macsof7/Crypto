package com.example.Crypto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CryptoException extends RuntimeException {
    
    public CryptoException(String message) {
        super(message);
    }
}