package com.example.demo.module.project.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.project.domain.dto.ProjectListDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProjectRepositoryExtension {
    List<ProjectListDto> findMyProjectsAsManager(Account createdBy);
    List<ProjectListDto> findMyProjectAsWorker(Account worker);
   // AccountAuthDto findByEmailWhenLogin(String email);
   // AccountRoleDto findRoleByEmail(String email);
    List<ProjectListDto> findAllProjectsAsManager();
    List<ProjectListDto> findAllProjectsAsWorker();
}
