package com.example.demo.module.account.domain.dto;
import com.example.demo.module.role.domain.entity.Role;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ToString
public class AccountRegisterDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min=4, max=10)
    private String password;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;

    private String role;
}
