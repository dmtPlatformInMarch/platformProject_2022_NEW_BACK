package com.example.demo.module.account.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountRoleDto {
    private String email;
    private String roleName;

    @QueryProjection
    public AccountRoleDto(String email, String roleName ) {
        this.email = email;
        this.roleName = roleName;
    }
}
