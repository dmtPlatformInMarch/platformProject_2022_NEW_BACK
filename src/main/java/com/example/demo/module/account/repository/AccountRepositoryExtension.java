package com.example.demo.module.account.repository;

import com.example.demo.module.account.domain.dto.AccountAppDto;
import com.example.demo.module.account.domain.dto.AccountAuthDto;
import com.example.demo.module.account.domain.dto.AccountRoleDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountRepositoryExtension {
    AccountAuthDto findByEmailWhenLogin(String email);
    AccountRoleDto findRoleByEmail(String email);
    AccountAppDto findAccountWithApplication(String email);
}
