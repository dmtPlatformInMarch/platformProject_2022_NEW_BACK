package com.example.demo.module.resume.domain.dto;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
public class ResumeCertificateDto {
    private Long id;

    private Long resumeId;

    private String certificateName;

    private String grade;
}
