package com.example.demo.module.resume.domain.dto;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.resume.domain.entity.ResumeAdditionalContact;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeDto {

    private Long id;
    private String title;
    private int resumeHopedFieldCnt;
    private String hopedWorkingPlace;
    private String hopedWorkingPeriod;
    private String content;

    private String createdBy;

    private boolean isOpened;

    private List<ResumeAbilityDto> resumeAbilityDtos = new ArrayList<>();
    private List<ResumeAcademyDto> resumeAcademyDtos = new ArrayList<>();
    private List<ResumeCertificateDto> resumeCertificateDtos = new ArrayList<>();
    private List<ResumeHopedFieldDto> resumeHopedFieldDtos = new ArrayList<>();
    private List<ResumeAdditionalContactDto> resumeAdditionalContactDtos = new ArrayList<>();

    @QueryProjection
    public ResumeDto(Long id, String title, int resumeHopedFieldCnt, String hopedWorkingPlace, String hopedWorkingPeriod,
        String content, String createdBy, boolean isOpened)
    {
        this.id = id;
        this.title = title;
        this.resumeHopedFieldCnt = resumeHopedFieldCnt;
        this.hopedWorkingPeriod = hopedWorkingPeriod;
        this.hopedWorkingPlace = hopedWorkingPlace;
        this.content = content;
        this.createdBy = createdBy;
        this.isOpened = isOpened;
    }
}
