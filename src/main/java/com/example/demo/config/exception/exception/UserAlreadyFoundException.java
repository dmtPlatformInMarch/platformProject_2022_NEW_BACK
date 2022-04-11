package com.example.demo.config.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class UserAlreadyFoundException  extends RuntimeException{
    public UserAlreadyFoundException(String message){
        super(message);
    }
}
