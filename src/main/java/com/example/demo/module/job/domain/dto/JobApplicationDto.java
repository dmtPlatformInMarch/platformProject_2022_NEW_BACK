package com.example.demo.module.job.domain.dto;

import com.example.demo.module.job.domain.domain.ApplicationStatus;
import com.example.demo.module.resume.domain.entity.Resume;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class JobApplicationDto {
    private Long id;

    private boolean isWorkerApplied;

    private Long fileId;
    private String fileName;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


    private String applicationContent;

    private ApplicationStatus applicationStatus;

    private Resume resume;

    private Long resumeId;

    private String resumeTitle;

    @QueryProjection
    public JobApplicationDto(Long id, boolean isWorkerApplied,
                             LocalDateTime createdDate, LocalDateTime lastModifiedDate,
                             String applicationContent, ApplicationStatus applicationStatus, Long resumeId, String title) {
        this.id = id;
        this.isWorkerApplied = isWorkerApplied;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.applicationContent = applicationContent;
        this.applicationStatus = applicationStatus;
        this.resumeId = resumeId;
        this.resumeTitle = title;
    }
}
