package com.example.demo.module.job.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.job.domain.dto.QJobListDto is a Querydsl Projection type for JobListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QJobListDto extends ConstructorExpression<JobListDto> {

    private static final long serialVersionUID = 2132526820L;

    public QJobListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> fileId, com.querydsl.core.types.Expression<String> fileName, com.querydsl.core.types.Expression<Long> applicationId, com.querydsl.core.types.Expression<Long> projectId, com.querydsl.core.types.Expression<com.example.demo.module.job.domain.domain.JobStatus> jobStatus, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> lastModifiedDate) {
        super(JobListDto.class, new Class<?>[]{long.class, long.class, String.class, long.class, long.class, com.example.demo.module.job.domain.domain.JobStatus.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, fileId, fileName, applicationId, projectId, jobStatus, createdDate, lastModifiedDate);
    }

}

