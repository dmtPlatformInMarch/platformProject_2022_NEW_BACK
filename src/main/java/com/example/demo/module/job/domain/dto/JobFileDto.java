package com.example.demo.module.job.domain.dto;

import com.example.demo.module.job.domain.domain.ApplicationStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class JobFileDto {
    private Long id;

    private boolean isWorkerApplied;

    private Long fileId;
    private String fileName;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


    private String applicationContent;

    private ApplicationStatus applicationStatus;

    private Long resumeId;


    @QueryProjection
    public JobFileDto(Long id, boolean isWorkerApplied,
                      LocalDateTime createdDate, LocalDateTime lastModifiedDate,
                      String applicationContent, ApplicationStatus applicationStatus) {
        this.id = id;
        this.isWorkerApplied = isWorkerApplied;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.applicationContent = applicationContent;
        this.applicationStatus = applicationStatus;
    }
}
