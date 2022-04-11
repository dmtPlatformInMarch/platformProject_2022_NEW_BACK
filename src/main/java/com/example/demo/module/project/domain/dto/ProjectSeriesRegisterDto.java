package com.example.demo.module.project.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ProjectSeriesRegisterDto {
    private Long id;
    private String title;
    private String content;
    private boolean isOpened;
    private String createdBy;

    @QueryProjection
    public ProjectSeriesRegisterDto(Long id, String title, String content, boolean isOpened, String createdBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isOpened = isOpened;
        this.createdBy = createdBy;
    }
}
