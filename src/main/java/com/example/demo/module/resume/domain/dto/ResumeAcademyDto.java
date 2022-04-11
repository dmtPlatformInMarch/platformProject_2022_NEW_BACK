package com.example.demo.module.resume.domain.dto;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
public class ResumeAcademyDto{

    private Long id;

    private Long resumeId;

    private String schoolType;
    private String schoolName;

    private String majorOrDesc;
}