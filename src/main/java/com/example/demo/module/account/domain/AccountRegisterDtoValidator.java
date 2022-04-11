package com.example.demo.module.account.domain;

import com.example.demo.module.account.domain.dto.AccountRegisterDto;
import com.example.demo.module.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AccountRegisterDtoValidator implements Validator {
    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(AccountRegisterDto.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        AccountRegisterDto memberForm = (AccountRegisterDto) object;

        if (accountRepository.existsByEmail(memberForm.getEmail())) {
            errors.rejectValue("email", "invalid.email",
                    new Object[]{memberForm.getEmail()},
                    "이미 사용 중인 이메일입니다.");
        }
    }
}
