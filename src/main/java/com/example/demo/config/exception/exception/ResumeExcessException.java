package com.example.demo.config.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResumeExcessException extends RuntimeException{
    public ResumeExcessException(String message){
        super(message);
    }

}
