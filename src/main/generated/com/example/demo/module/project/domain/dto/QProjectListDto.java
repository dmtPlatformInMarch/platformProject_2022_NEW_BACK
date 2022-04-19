package com.example.demo.module.project.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.project.domain.dto.QProjectListDto is a Querydsl Projection type for ProjectListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProjectListDto extends ConstructorExpression<ProjectListDto> {

    private static final long serialVersionUID = 1383714916L;

    public QProjectListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> firstFieldName, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<? extends java.util.Date> deadline, com.querydsl.core.types.Expression<Boolean> paymentType, com.querydsl.core.types.Expression<Integer> fixedPayment, com.querydsl.core.types.Expression<Integer> toPayment, com.querydsl.core.types.Expression<Integer> fromPayment, com.querydsl.core.types.Expression<Integer> favoriteCnt, com.querydsl.core.types.Expression<Boolean> isOpened, com.querydsl.core.types.Expression<String> createdBy) {
        super(ProjectListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class, java.util.Date.class, boolean.class, int.class, int.class, int.class, int.class, boolean.class, String.class}, id, title, content, firstFieldName, createdDate, deadline, paymentType, fixedPayment, toPayment, fromPayment, favoriteCnt, isOpened, createdBy);
    }

}

