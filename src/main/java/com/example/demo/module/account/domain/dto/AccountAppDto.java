package com.example.demo.module.account.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountAppDto {
    private Long id;
    private String firstName;
    private String lastName;

    private String phoneNumber;

    private String email;
    private String roleName;

    @QueryProjection
    public AccountAppDto(
            Long id,
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
                         String roleName ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roleName = roleName;
    }
}
