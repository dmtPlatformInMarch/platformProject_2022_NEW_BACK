package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ABILITY_SOURCE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AbilitySource extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ABILITY_SOURCE_ID")
    private Long id;

    private String abilityType;
}
