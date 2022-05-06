package com.example.demo.module.payment.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.domain.domain.QJob;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.job.domain.dto.QJobListDto;
import com.example.demo.module.payment.domain.Payment;
import com.example.demo.module.payment.domain.PaymentDto;
import com.example.demo.module.payment.domain.QPayment;
import com.example.demo.module.payment.domain.QPaymentDto;
import com.example.demo.module.project.domain.entity.Project;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class PaymentRepositoryExtensionImpl extends QuerydslRepositorySupport implements PaymentRepositoryExtension {
    public PaymentRepositoryExtensionImpl() {
        super(Payment.class);
    }

    @Override
    public List<PaymentDto> findMyPayment(Account worker) {
        QPayment payment = QPayment.payment;
        JPQLQuery<PaymentDto> jpqlQuery = from(payment)
                .where(payment.worker.eq(worker))
                .select(new QPaymentDto(
                       payment.id,
                        payment.job.id.as("jobId"),
                        payment.amount,
                        payment.comment,
                        payment.worker.email.as("workerEmail"),
                        payment.manager.email.as("managerEmail"),
                        payment.job.customFile.id.as("fileId")
                ));
        return jpqlQuery.fetch();
    }

}
