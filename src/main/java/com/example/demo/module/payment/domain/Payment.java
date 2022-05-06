package com.example.demo.module.payment.domain;


import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.domain.domain.JobStatus;
import com.example.demo.module.project.domain.entity.Project;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;

    private Long amount;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID")
    private Account worker;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Account manager;

}
