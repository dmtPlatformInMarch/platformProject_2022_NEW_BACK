package com.example.demo.module.project.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.module.project.domain.dto.QProjectFieldListDto is a Querydsl Projection type for ProjectFieldListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProjectFieldListDto extends ConstructorExpression<ProjectFieldListDto> {

    private static final long serialVersionUID = 1945428964L;

    public QProjectFieldListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> fieldName, com.querydsl.core.types.Expression<Long> parentId, com.querydsl.core.types.Expression<Integer> depth) {
        super(ProjectFieldListDto.class, new Class<?>[]{long.class, String.class, long.class, int.class}, id, fieldName, parentId, depth);
    }

}

