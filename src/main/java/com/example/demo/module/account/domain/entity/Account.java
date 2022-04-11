package com.example.demo.module.account.domain.entity;

import com.example.demo.module.common.domain.BaseEntity;
import com.example.demo.module.role.domain.entity.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String firstName;
    private String lastName;

    private String phoneNumber;

    private String name;

    //role 추가
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    private Role role;

    //resume 추가
    private int resumeCnt = 0;

    //참여 프로젝트들 추가
    //참여 작업들 추가

    //이메일 관련 작업

    //상세 프로필 관련 작업 추가

    public void incrementResumeCnt() {
        this.resumeCnt += 1;
    }

    public void decrementResumeCnt() {
        this.resumeCnt -=1;
    }

    public void setName() { this.name = this.firstName + this.lastName; }
}
