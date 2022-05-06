package com.example.demo.module.job.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.job.domain.dto.QJobApplicationDto is a Querydsl Projection type for JobApplicationDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QJobApplicationDto extends ConstructorExpression<JobApplicationDto> {

    private static final long serialVersionUID = -1775704436L;

    public QJobApplicationDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Boolean> isWorkerApplied, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> lastModifiedDate, com.querydsl.core.types.Expression<String> applicationContent, com.querydsl.core.types.Expression<com.example.demo.module.job.domain.domain.ApplicationStatus> applicationStatus, com.querydsl.core.types.Expression<Long> resumeId, com.querydsl.core.types.Expression<String> title) {
        super(JobApplicationDto.class, new Class<?>[]{long.class, boolean.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, com.example.demo.module.job.domain.domain.ApplicationStatus.class, long.class, String.class}, id, isWorkerApplied, createdDate, lastModifiedDate, applicationContent, applicationStatus, resumeId, title);
    }

}

