package com.example.demo.module.project.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProjectSeriesRepositoryExtension {
   // AccountAuthDto findByEmailWhenLogin(String email);
   // AccountRoleDto findRoleByEmail(String email);
    List<ProjectSeriesRegisterDto> findMySeriesAndOpened(Account account);
}
