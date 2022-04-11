package com.example.demo.config.exception.filter;

import lombok.*;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private Date timestamp;
    private String details;
}
