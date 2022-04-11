package com.example.demo.module.resume.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.resume.domain.dto.ResumeListDto;
import com.example.demo.module.resume.domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ResumeRepositoryExtension {
    List<ResumeListDto> findMyResumeList(Account account);
}
