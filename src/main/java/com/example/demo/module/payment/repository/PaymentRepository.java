package com.example.demo.module.payment.repository;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.repository.JobRepositoryExtension;
import com.example.demo.module.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentRepositoryExtension {
    boolean existsByJob(Job job);
    Payment findByJob(Job job);
}
