package com.example.demo.module.resume.domain.dto;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
public class ResumeAdditionalContactDto {
    private Long id;

    private Long resumeId;

    @OneToOne
    private Long contactTypeId;

    private String contact;

    private String contactType;
}
