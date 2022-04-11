package com.example.demo.module.project.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_FIELD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = {"parentProjectField"})
public class ProjectField extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "PROJECT_FIELD_ID")
    private Long id;

    //작업 분야의 이름
    private String fieldName;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_PROJECT_FIELD_ID", referencedColumnName = "PROJECT_FIELD_ID")
    private ProjectField parentProjectField;

    //현재 분야가 몇 depth인지
    //ex 번역 (depth 1) > 한영 번역 (depth 2)
    private int depth;


    private String explanation;
}
