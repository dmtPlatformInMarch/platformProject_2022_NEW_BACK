package com.example.demo.module.payment.domain;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.module.payment.domain.QPaymentListDto is a Querydsl Projection type for PaymentListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPaymentListDto extends ConstructorExpression<PaymentListDto> {

    private static final long serialVersionUID = 910652053L;

    public QPaymentListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> jobId, com.querydsl.core.types.Expression<Long> amount, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<String> workerEmail, com.querydsl.core.types.Expression<String> managerEmail, com.querydsl.core.types.Expression<Long> fileId) {
        super(PaymentListDto.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, String.class, long.class}, id, jobId, amount, comment, workerEmail, managerEmail, fileId);
    }

}

