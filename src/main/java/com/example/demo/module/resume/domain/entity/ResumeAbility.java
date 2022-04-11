package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESUME_ABILITY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumeAbility {
    @Id
    @GeneratedValue
    @Column(name = "RESUME_ABILITY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    @OneToOne
    @JoinColumn(name = "ABILITY_ID")
    private AbilitySource abilitySource;

    private String abilityDesc;
}
