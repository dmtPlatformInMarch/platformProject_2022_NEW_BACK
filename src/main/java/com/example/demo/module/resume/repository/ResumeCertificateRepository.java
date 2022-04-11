package com.example.demo.module.resume.repository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.domain.entity.ResumeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeCertificateRepository extends JpaRepository<ResumeCertificate, Long> {
    List<ResumeCertificate> findByResume(Resume resume);
}
