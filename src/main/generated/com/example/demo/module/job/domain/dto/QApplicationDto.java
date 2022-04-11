package com.example.demo.module.job.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.module.job.domain.dto.QApplicationDto is a Querydsl Projection type for ApplicationDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QApplicationDto extends ConstructorExpression<ApplicationDto> {

    private static final long serialVersionUID = 1358274415L;

    public QApplicationDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> projectId, com.querydsl.core.types.Expression<Long> resumeId, com.querydsl.core.types.Expression<String> resumeTitle, com.querydsl.core.types.Expression<String> workerEmail, com.querydsl.core.types.Expression<Long> workerId, com.querydsl.core.types.Expression<Long> managerId, com.querydsl.core.types.Expression<String> managerEmail, com.querydsl.core.types.Expression<Boolean> isWorkerApplied, com.querydsl.core.types.Expression<String> applicationContent, com.querydsl.core.types.Expression<com.example.demo.module.job.domain.domain.ApplicationStatus> applicationStatus, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> lastModifiedDate) {
        super(ApplicationDto.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, long.class, long.class, String.class, boolean.class, String.class, com.example.demo.module.job.domain.domain.ApplicationStatus.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, projectId, resumeId, resumeTitle, workerEmail, workerId, managerId, managerEmail, isWorkerApplied, applicationContent, applicationStatus, createdDate, lastModifiedDate);
    }

}

