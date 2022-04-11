package com.example.demo.module.job.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>, ApplicationRepositoryExtension {
    boolean existsByProjectAndWorker(Project project, Account worker);
    Long countByProjectAndWorker(Project project, Account worker);
    Application findByProjectAndWorker(Project project, Account worker);
}
