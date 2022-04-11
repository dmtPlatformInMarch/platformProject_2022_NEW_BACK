package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESUME_CERTIFICATE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResumeCertificate extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "RESUME_CERTIFICATE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    private String certificateName;

    private String grade;
}
