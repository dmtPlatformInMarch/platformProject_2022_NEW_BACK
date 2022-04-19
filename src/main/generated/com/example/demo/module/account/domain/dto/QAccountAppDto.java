package com.example.demo.module.account.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.account.domain.dto.QAccountAppDto is a Querydsl Projection type for AccountAppDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccountAppDto extends ConstructorExpression<AccountAppDto> {

    private static final long serialVersionUID = -2122455269L;

    public QAccountAppDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> firstName, com.querydsl.core.types.Expression<String> lastName, com.querydsl.core.types.Expression<String> phoneNumber, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> roleName) {
        super(AccountAppDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class}, id, firstName, lastName, phoneNumber, email, roleName);
    }

}

