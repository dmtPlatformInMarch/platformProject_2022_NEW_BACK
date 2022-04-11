package com.example.demo.module.project.repository;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.project.domain.entity.ProjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectFieldRepository extends JpaRepository<ProjectField, Long>, ProjectFieldRepositoryExtension {
   // Project findBy(String email);
   // int countByEmail(String email);
   // boolean existsByEmail(String email);
    List<ProjectField> findAll();
}
