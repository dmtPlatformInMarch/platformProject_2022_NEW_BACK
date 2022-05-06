package com.example.demo.module.resume.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.resume.domain.dto.QResumeDto is a Querydsl Projection type for ResumeDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResumeDto extends ConstructorExpression<ResumeDto> {

    private static final long serialVersionUID = 1732624626L;

    public QResumeDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<Integer> resumeHopedFieldCnt, com.querydsl.core.types.Expression<String> hopedWorkingPlace, com.querydsl.core.types.Expression<String> hopedWorkingPeriod, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> createdBy, com.querydsl.core.types.Expression<Boolean> isOpened) {
        super(ResumeDto.class, new Class<?>[]{long.class, String.class, int.class, String.class, String.class, String.class, String.class, boolean.class}, id, title, resumeHopedFieldCnt, hopedWorkingPlace, hopedWorkingPeriod, content, createdBy, isOpened);
    }

}

