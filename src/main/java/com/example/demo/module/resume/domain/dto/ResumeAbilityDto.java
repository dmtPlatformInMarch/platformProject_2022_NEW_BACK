package com.example.demo.module.resume.domain.dto;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
public class ResumeAbilityDto {
    private Long id;

    private Long resumeId;

    private Long abilitySourceId;
    private String abilityType;
    private String desc;
}
