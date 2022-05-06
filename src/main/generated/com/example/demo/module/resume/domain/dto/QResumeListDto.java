package com.example.demo.module.resume.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.resume.domain.dto.QResumeListDto is a Querydsl Projection type for ResumeListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResumeListDto extends ConstructorExpression<ResumeListDto> {

    private static final long serialVersionUID = 1888659956L;

    public QResumeListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> createdBy, com.querydsl.core.types.Expression<Boolean> isOpened, com.querydsl.core.types.Expression<Long> firstWorkFieldId, com.querydsl.core.types.Expression<Long> secondWorkFieldId, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate) {
        super(ResumeListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, boolean.class, long.class, long.class, java.time.LocalDateTime.class}, id, title, content, createdBy, isOpened, firstWorkFieldId, secondWorkFieldId, createdDate);
    }

}

