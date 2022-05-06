package com.example.demo.module.payment.domain;


import com.example.demo.module.common.domain.BaseEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaymentListDto extends BaseEntity {
    private Long id;
    private Long jobId;
    private Long amount;
    private String comment;
    private String workerEmail;
    private String managerEmail;
    private Long fileId;
    private String bank;
    private String account;
    private String accountName;

    @QueryProjection
    public PaymentListDto(
            Long id,
            Long jobId,
            Long amount,
            String comment,
            String workerEmail,
            String managerEmail,
            Long fileId
    ) {
        this.id = id;
        this.jobId = jobId;
        this.amount = amount;
        this.comment = comment;
        this.workerEmail = workerEmail;
        this.managerEmail = managerEmail;
        this.fileId = fileId;
    }
}
