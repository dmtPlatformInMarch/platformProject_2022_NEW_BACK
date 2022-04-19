package com.example.demo.module.job.domain.domain;

import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.project.domain.entity.Project;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "JOB")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Job extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "JOB_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOM_FILE_ID")
    private CustomFile customFile;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    private String comment;

    private Long progress;

}
