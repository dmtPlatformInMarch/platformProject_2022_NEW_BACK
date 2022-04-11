package com.example.demo.module.role.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE_HIERARCHY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"id", "childName", "parentName"})
public class RoleHierarchy extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ROLE_HIERARCHY_ID")
    private Long id;

    @Column(name = "CHILD_NAME")
    private String childName;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_NAME", referencedColumnName = "CHILD_NAME")
    private RoleHierarchy parentName;

    @OneToMany(mappedBy = "parentName", cascade={CascadeType.ALL})
    private Set<RoleHierarchy> roleHierarchy = new HashSet<>();
}
