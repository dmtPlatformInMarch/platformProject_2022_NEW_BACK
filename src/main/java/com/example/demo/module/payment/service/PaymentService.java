package com.example.demo.module.payment.service;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.repository.CustomFileRepository;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.repository.ApplicationRepository;
import com.example.demo.module.job.repository.JobRepository;
import com.example.demo.module.payment.domain.Payment;
import com.example.demo.module.payment.domain.PaymentDto;
import com.example.demo.module.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustomFileRepository customFileRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public PaymentDto createOrUpdatePayment(PaymentDto data) {
        log.info("payment service");
        System.out.println("data : " + data);

        CustomFile customFile = customFileRepository.getById(data.getFileId());
        log.info("after file");
        Job job = jobRepository.findByCustomFile(customFile);
        log.info("after job");
        Application application = job.getApplication();
        log.info("after application");
        Payment payment = new Payment();

        //update
        if(paymentRepository.existsByJob(job)) {
            log.info("update");
            payment = paymentRepository.findByJob(job);
            payment.setAmount(data.getAmount());
        } else { //create

            log.info("create");
            payment.setJob(job);
            payment.setManager(application.getManager());
            payment.setWorker(application.getWorker());
            payment.setAmount(data.getAmount());
        }
        paymentRepository.save(payment);
        return data;
    }

    @Transactional
    public List<PaymentDto> getMyPayments(PaymentDto data) {
        System.out.println("data : " + data);
        Account worker = accountRepository.findByEmail(data.getWorkerEmail());
        return paymentRepository.findMyPayment(worker);
    }

    @Transactional
    public PaymentDto getAccountInfo(PaymentDto data) {
        System.out.println("data : " + data);
        Account worker = accountRepository.findByEmail(data.getWorkerEmail());

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAccount(worker.getBankAccount());
        paymentDto.setBank(worker.getBank());
        paymentDto.setAccountName(worker.getAccountName());

        return paymentDto;
    }

    @Transactional
    public void saveAccountInfo(PaymentDto data) {
        System.out.println("data : " + data);
        Account worker = accountRepository.findByEmail(data.getWorkerEmail());

        worker.setBankAccount(data.getAccount());
        worker.setBank(data.getBank());
        worker.setAccountName(data.getAccountName());

        accountRepository.save(worker);
    }
}
