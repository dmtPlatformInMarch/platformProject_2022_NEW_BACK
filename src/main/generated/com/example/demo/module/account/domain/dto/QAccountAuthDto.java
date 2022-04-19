package com.example.demo.module.account.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.account.domain.dto.QAccountAuthDto is a Querydsl Projection type for AccountAuthDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccountAuthDto extends ConstructorExpression<AccountAuthDto> {

    private static final long serialVersionUID = -1223737446L;

    public QAccountAuthDto(com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> password, com.querydsl.core.types.Expression<String> firstName, com.querydsl.core.types.Expression<String> lastName, com.querydsl.core.types.Expression<String> phoneNumber, com.querydsl.core.types.Expression<String> roleName) {
        super(AccountAuthDto.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class}, email, password, firstName, lastName, phoneNumber, roleName);
    }

}

