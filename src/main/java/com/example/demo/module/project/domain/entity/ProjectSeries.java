package com.example.demo.module.project.domain.entity;

import com.example.demo.module.account.domain.entity.Account;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECT_SERIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"id", "content", "createdBy"})
public class ProjectSeries {
    @Id
    @GeneratedValue
    @Column(name = "PROJECT_SERIES_ID")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "projectSeries")
    private List<Project> projectList = new ArrayList<>();

    private String content;

    private boolean isOpened;

    @OneToOne
    private Account createdBy;

    public void addProject(Project project) {
        this.projectList.add(project);
    }
    public void removeProject(Project project) { this.projectList.remove(project); }
}
