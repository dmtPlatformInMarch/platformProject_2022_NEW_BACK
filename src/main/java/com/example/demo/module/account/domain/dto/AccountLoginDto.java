package com.example.demo.module.account.domain.dto;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ToString
public class AccountLoginDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min=1, max=20)
    private String password;
}
