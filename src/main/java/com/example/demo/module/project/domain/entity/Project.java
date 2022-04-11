package com.example.demo.module.project.domain.entity;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.job.domain.domain.Application;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJECT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Project extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "PROJECT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_SERIES_ID")
    private ProjectSeries projectSeries;

    @OneToOne
    private Account createdBy;

    private String title;

    @Lob @Basic(fetch = FetchType.EAGER)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="FIRST_FIELD_ID")
    private ProjectField firstField;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SECOND_FIELD_ID")
    private ProjectField secondField;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="THIRD_FIELD_ID")
    private ProjectField thirdField;

    private boolean paymentType;
    //false is default, fixed Type
    private Integer fixedPayment;
    private Integer toPayment;
    private Integer fromPayment;

    private Date deadline;
    private boolean isOpened;

    private int favoriteCnt;
    private int jobCnt;
    private int viewCnt;

    @OneToMany(mappedBy = "project")
    private List<Application> applicationList = new ArrayList<>();

    public void addApplication(Application app) {
        this.applicationList.add(app);
    }
}
