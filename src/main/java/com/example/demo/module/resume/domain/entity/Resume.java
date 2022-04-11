package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESUME")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"id", "title", "content", "hopedWorkingPlace", "hopedWorkingPeriod", "createdBy", "isOpened"})
public class Resume extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "RESUME_ID")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "resume")
    private List<ResumeAbility> resumeAbilities = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<ResumeAcademy> resumeAcademies = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<ResumeCertificate> resumeCertificates = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<ResumeHopedField> resumeHopedFields = new ArrayList<>();
    private int resumeHopedFieldCnt = 0;

    @OneToMany(mappedBy = "resume")
    private List<ResumeAdditionalContact> resumeAdditionalContacts = new ArrayList<>();

    private String hopedWorkingPlace;
    private String hopedWorkingPeriod;

    private String content;

    @OneToOne
    private Account createdBy;

    private boolean isOpened;

    public void incrementHopedFieldCnt() {
        this.resumeHopedFieldCnt+=1;
    }
    public void decrementHopedFieldCnt() {
        this.resumeHopedFieldCnt-=1;
    }

    public void addResumeAbilityList(ResumeAbility resumeAbility) {
        this.resumeAbilities.add(resumeAbility);
    }
    public void addResumeAcademyList(ResumeAcademy resumeAcademy) {
        this.resumeAcademies.add(resumeAcademy);
    }
    public void addResumeCertificateList(ResumeCertificate resumeCertificate) {
        this.resumeCertificates.add(resumeCertificate);
    }
    public void addResumeAdditionalContactList(ResumeAdditionalContact resumeAdditionalContact) {
        this.resumeAdditionalContacts.add(resumeAdditionalContact);
    }
    public void addResumeHopedFieldList(ResumeHopedField resumeHopedFieldu) {
        this.resumeHopedFields.add(resumeHopedFieldu);
    }
}
