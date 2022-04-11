package com.example.demo.module.job.repository;

import com.example.demo.module.job.domain.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JobRepositoryExtension {

}
