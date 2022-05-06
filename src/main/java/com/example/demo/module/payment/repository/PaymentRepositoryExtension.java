package com.example.demo.module.payment.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.payment.domain.PaymentDto;
import com.example.demo.module.project.domain.entity.Project;
import org.hibernate.jdbc.Work;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PaymentRepositoryExtension {
    List<PaymentDto> findMyPayment(Account worker);
}
