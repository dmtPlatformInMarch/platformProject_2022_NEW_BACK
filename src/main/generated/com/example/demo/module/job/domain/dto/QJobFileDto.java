package com.example.demo.module.job.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.module.job.domain.dto.QJobFileDto is a Querydsl Projection type for JobFileDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QJobFileDto extends ConstructorExpression<JobFileDto> {

    private static final long serialVersionUID = 1095560518L;

    public QJobFileDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Boolean> isWorkerApplied, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> lastModifiedDate, com.querydsl.core.types.Expression<String> applicationContent, com.querydsl.core.types.Expression<com.example.demo.module.job.domain.domain.ApplicationStatus> applicationStatus) {
        super(JobFileDto.class, new Class<?>[]{long.class, boolean.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, com.example.demo.module.job.domain.domain.ApplicationStatus.class}, id, isWorkerApplied, createdDate, lastModifiedDate, applicationContent, applicationStatus);
    }

}

