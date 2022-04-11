package com.example.demo.module.resume.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ContactType extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "CONTACT_TYPE_ID")
    private Long id;

    private String contactType;
}
