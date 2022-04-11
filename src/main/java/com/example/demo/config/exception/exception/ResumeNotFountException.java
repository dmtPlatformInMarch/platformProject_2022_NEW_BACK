package com.example.demo.config.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResumeNotFountException extends RuntimeException{
    public ResumeNotFountException(String message){
        super(message);
    }

}

