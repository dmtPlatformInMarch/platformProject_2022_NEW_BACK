package com.example.demo.module.job.domain.dto;

import com.example.demo.module.job.domain.domain.ApplicationStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class ApplicationDto {
    private Long id;
    private Long projectId;
    private Long resumeId;
    private String resumeTitle;
    private String workerEmail;

    private Long workerId;
    private Long managerId;
    private String managerEmail;

    private boolean isWorkerApplied;
    private String applicationContent;
    private ApplicationStatus applicationStatus;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    private long jobCnt;

    @QueryProjection
    public ApplicationDto(Long id,
                          Long projectId,
                          Long resumeId,
                          String resumeTitle,
                          String workerEmail,
                          Long workerId,
                          Long managerId,
                          String managerEmail,
                          boolean isWorkerApplied,
                          String applicationContent,
                          ApplicationStatus applicationStatus,
                          LocalDateTime createdDate,
                          LocalDateTime lastModifiedDate)
    {
        this.id = id;
        this.projectId = projectId;
        this.resumeId = resumeId;
        this.resumeTitle = resumeTitle;
        this.workerEmail = workerEmail;
        this.workerId = workerId;
        this.managerId = managerId;
        this.managerEmail = managerEmail;
        this.isWorkerApplied = isWorkerApplied;
        this.applicationContent = applicationContent;
        this.applicationStatus = applicationStatus;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
