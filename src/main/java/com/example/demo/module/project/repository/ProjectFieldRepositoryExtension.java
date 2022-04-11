package com.example.demo.module.project.repository;

import com.example.demo.module.project.domain.dto.ProjectFieldListDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProjectFieldRepositoryExtension {
   // AccountAuthDto findByEmailWhenLogin(String email);
   // AccountRoleDto findRoleByEmail(String email);
    List<ProjectFieldListDto> findFieldsAll();
}
