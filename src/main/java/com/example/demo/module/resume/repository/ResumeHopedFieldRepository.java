package com.example.demo.module.resume.repository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.domain.entity.ResumeHopedField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeHopedFieldRepository extends JpaRepository<ResumeHopedField, Long> {
    List<ResumeHopedField> findByResume(Resume resume);
}
