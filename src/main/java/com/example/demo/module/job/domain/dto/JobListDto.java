package com.example.demo.module.job.domain.dto;

import com.example.demo.module.job.domain.domain.ApplicationStatus;
import com.example.demo.module.job.domain.domain.JobStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class JobListDto {
    private Long id;

    private Long fileId;
    private String fileName;
    private Long applicationId;
    private Long projectId;
    private JobStatus jobStatus;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    private String workerEmail;

    @QueryProjection
    public JobListDto(
            Long id,
            Long fileId,
            String fileName,
            Long applicationId,
            Long projectId,
            JobStatus jobStatus,
            LocalDateTime createdDate,
            LocalDateTime lastModifiedDate
    ) {
        this.id = id;
        this.fileId = fileId;
        this.fileName = fileName;
        this.applicationId = applicationId;
        this.projectId = projectId;
        this.jobStatus = jobStatus;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
