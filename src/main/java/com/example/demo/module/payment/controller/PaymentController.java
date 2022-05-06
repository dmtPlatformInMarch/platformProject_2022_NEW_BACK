package com.example.demo.module.payment.controller;

import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.job.service.JobService;
import com.example.demo.module.payment.domain.PaymentDto;
import com.example.demo.module.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping(value = "/payment/new")
    public PaymentDto createOrUpdatePayment(@RequestBody PaymentDto data) {
        log.info("/payment/new");
        PaymentDto result = paymentService.createOrUpdatePayment(data);
        return result;
    }

    @PostMapping(value = "/payment/mine")
    public List<PaymentDto> getMyPayments(@RequestBody PaymentDto data) {
        log.info("/payment/mine");
        List<PaymentDto> result = paymentService.getMyPayments(data);
        return result;
    }

    @PostMapping(value = "/payment/account")
    public PaymentDto getAccountInfo(@RequestBody PaymentDto data) {
        log.info("/payment/account");
        PaymentDto result = paymentService.getAccountInfo(data);
        return result;
    }

    @PostMapping(value = "/payment/account/save")
    public void saveAccountInfo(@RequestBody PaymentDto data) {
        log.info("/payment/account/save");
        paymentService.saveAccountInfo(data);
    }
}
