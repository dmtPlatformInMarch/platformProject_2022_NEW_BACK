package com.example.demo.module.resume.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class ResumeListDto {

    private Long id;
    private String title;
    private String content;

    private String createdBy;

    private boolean isOpened;
    private Long firstWorkFieldId;
    private Long secondWorkFieldId;

    private LocalDateTime createdDate;

    @QueryProjection
    public ResumeListDto(Long id, String title, String content, String createdBy, boolean isOpened, Long firstWorkFieldId, Long secondWorkFieldId, LocalDateTime createdDate)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.isOpened = isOpened;
        this.firstWorkFieldId = firstWorkFieldId;
        this.secondWorkFieldId = secondWorkFieldId;
        this.createdDate = createdDate;
    }
}
