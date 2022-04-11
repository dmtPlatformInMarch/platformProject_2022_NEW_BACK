package com.example.demo.module.resume.repository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.domain.entity.ResumeAdditionalContact;
import com.example.demo.module.resume.domain.entity.ResumeCertificate;
import com.example.demo.module.resume.domain.entity.ResumeHopedField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeAdditionalContactRepository extends JpaRepository<ResumeAdditionalContact, Long> {
    List<ResumeAdditionalContact> findByResume(Resume resume);
}
