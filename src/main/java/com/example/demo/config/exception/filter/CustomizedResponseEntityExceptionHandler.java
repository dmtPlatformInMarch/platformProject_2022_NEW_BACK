package com.example.demo.config.exception.filter;

import com.example.demo.config.exception.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //Default exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse().builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler({ResumeExcessException.class})
    public final ResponseEntity<Object> handleUserNotAcceptableException(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse() .builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.FOUND);

    }


    @ExceptionHandler({UserAlreadyFoundException.class, TitleAlreadyFoundException.class})
    public final ResponseEntity<Object> handleUserFoundException(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse() .builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.FOUND);

    }

    @ExceptionHandler({UserNotFoundException.class, ResumeNotFountException.class, ProjectNotFoundException.class})
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse() .builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }
}
