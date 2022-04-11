package com.example.demo.module.resume.repository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.domain.entity.ResumeAbility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeAbilityRepository extends JpaRepository<ResumeAbility, Long> {
    List<ResumeAbility> findByResume(Resume resume);
}
