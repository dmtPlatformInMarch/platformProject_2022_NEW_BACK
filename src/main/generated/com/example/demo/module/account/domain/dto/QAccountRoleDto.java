package com.example.demo.module.account.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.account.domain.dto.QAccountRoleDto is a Querydsl Projection type for AccountRoleDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccountRoleDto extends ConstructorExpression<AccountRoleDto> {

    private static final long serialVersionUID = 799670796L;

    public QAccountRoleDto(com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> roleName) {
        super(AccountRoleDto.class, new Class<?>[]{String.class, String.class}, email, roleName);
    }

}

