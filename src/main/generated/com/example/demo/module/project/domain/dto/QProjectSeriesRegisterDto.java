package com.example.demo.module.project.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.project.domain.dto.QProjectSeriesRegisterDto is a Querydsl Projection type for ProjectSeriesRegisterDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProjectSeriesRegisterDto extends ConstructorExpression<ProjectSeriesRegisterDto> {

    private static final long serialVersionUID = -166676088L;

    public QProjectSeriesRegisterDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Boolean> isOpened, com.querydsl.core.types.Expression<String> createdBy) {
        super(ProjectSeriesRegisterDto.class, new Class<?>[]{long.class, String.class, String.class, boolean.class, String.class}, id, title, content, isOpened, createdBy);
    }

}

