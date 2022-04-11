package com.example.demo.config.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class ApplicationAlreadyFoundException extends RuntimeException{
    public ApplicationAlreadyFoundException(String message){
        super(message);
    }
}
