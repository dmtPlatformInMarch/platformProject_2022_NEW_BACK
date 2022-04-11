package com.example.demo.config.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class    TitleAlreadyFoundException extends RuntimeException{
    public TitleAlreadyFoundException(String message){
        super(message);
    }
}
