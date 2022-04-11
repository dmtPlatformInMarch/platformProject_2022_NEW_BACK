package com.example.demo.module.resume.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.resume.domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>, ResumeRepositoryExtension {
    List<Resume> findByCreatedBy(Account account);
}
