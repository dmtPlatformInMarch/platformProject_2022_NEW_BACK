package com.example.demo.module.account.service;

import com.example.demo.config.exception.exception.UserAlreadyFoundException;
import com.example.demo.config.exception.exception.UserNotFoundException;
import com.example.demo.module.account.domain.dto.AccountAppDto;
import com.example.demo.module.account.domain.dto.AccountRegisterDto;
import com.example.demo.module.account.domain.dto.AccountRegisteredDto;
import com.example.demo.module.account.domain.dto.AccountRoleDto;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;


    @Transactional
    public AccountRegisteredDto registerNewAccount(AccountRegisterDto accountForm) {
        AccountRegisteredDto result = new AccountRegisteredDto();
        result = modelMapper.map(accountForm, AccountRegisteredDto.class);
        accountForm.setPassword(passwordEncoder.encode(accountForm.getPassword()));
        Account newAccount = modelMapper.map(accountForm, Account.class);

        newAccount.setRole(roleRepository.findByRoleName(accountForm.getRole()));
        //인증 메일 보내는 로직 추가
        if(accountRepository.existsByEmail(accountForm.getEmail())) {
            result.setMessage("이미 존재하는 이메일입니다.");
            throw new UserAlreadyFoundException("이미 존재하는 이메일입니다.");
        }
        else {
            accountRepository.save(newAccount);
            result.setMessage("성공");
        }
        return result;
    }

    @Transactional
    public AccountRoleDto getAccountWithRoleByEmail(String email) {
        if(accountRepository.findRoleByEmail(email) == null)
            throw new UserNotFoundException("존재하지 않는 이메일입니다.");
        return accountRepository.findRoleByEmail(email);
    }

    @Transactional
    public AccountAppDto getAccountWithApp(AccountAppDto data) {
        System.out.println("get account with app service");
        System.out.println("data : " + data);

        AccountAppDto result = accountRepository.findAccountWithApplication(data.getEmail());
        return result;
    }
}
