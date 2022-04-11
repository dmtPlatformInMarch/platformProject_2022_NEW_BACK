package com.example.demo.module.resume.repository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.domain.entity.ResumeAcademy;
import com.example.demo.module.resume.domain.entity.ResumeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeAcademyRepository extends JpaRepository<ResumeAcademy, Long> {
    List<ResumeAcademy> findByResume(Resume resume);
}
