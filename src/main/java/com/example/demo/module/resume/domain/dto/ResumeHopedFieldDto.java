package com.example.demo.module.resume.domain.dto;

import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.project.domain.entity.ProjectField;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
public class ResumeHopedFieldDto {

    private Long id;

    private Long resumeId;

    private Long firstFieldId;

    private Long secondFieldId;

    private String firstFieldType;
    private String secondFieldType;
}
