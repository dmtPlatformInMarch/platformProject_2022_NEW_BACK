package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESUME_ACADEMY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResumeAcademy extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "RESUME_ACADEMY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    private String schoolType;
    private String schoolName;

    private String majorOrDesc;
}