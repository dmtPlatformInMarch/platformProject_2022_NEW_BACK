package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.project.domain.entity.ProjectField;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESUME_HOPED_FIELD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResumeHopedField extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "RESUME_HOPED_FIELD_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    @OneToOne
    private ProjectField firstField;

    @OneToOne
    private ProjectField secondField;
}
