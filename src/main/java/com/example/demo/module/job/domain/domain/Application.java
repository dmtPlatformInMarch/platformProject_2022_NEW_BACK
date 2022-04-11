package com.example.demo.module.job.domain.domain;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.resume.domain.entity.Resume;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "APPLICATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Application extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "APPLICATION")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @OneToOne
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    @OneToOne
    @JoinColumn(name = "WORKER_ID")
    private Account worker;

    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Account manager;

    //Manager가 검색해서 apply 했으면 false
    //worker가 직접 apply 했으면 true
    private boolean isWorkerApplied;

    private String applicationContent;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @OneToMany(mappedBy = "application")
    private List<Job> jobList = new ArrayList<>();

    public void addJob(Job job) { this.jobList.add(job); }
}
