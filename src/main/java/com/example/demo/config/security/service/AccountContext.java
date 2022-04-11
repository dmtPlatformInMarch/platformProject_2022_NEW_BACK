package com.example.demo.config.security.service;

import com.example.demo.module.account.domain.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class AccountContext extends User {
    private Account account;

    public AccountContext(Account account, List<GrantedAuthority> roles) {
        super(account.getEmail(), account.getPassword(), roles);
        this.account = account;
    }
}
