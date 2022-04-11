package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESUME_ADDITIONAL_CONTACT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResumeAdditionalContact extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "RESUME_ADDITIONAL_CONTACT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    @OneToOne
    @JoinColumn(name = "CONTACT_TYPE_ID")
    private ContactType contactType;

    private String contact;
}
