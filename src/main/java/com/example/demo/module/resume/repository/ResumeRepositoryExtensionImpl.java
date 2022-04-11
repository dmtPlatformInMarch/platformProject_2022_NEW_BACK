package com.example.demo.module.resume.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.domain.entity.QAccount;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.dto.QProjectSeriesRegisterDto;
import com.example.demo.module.resume.domain.dto.QResumeListDto;
import com.example.demo.module.resume.domain.dto.ResumeListDto;
import com.example.demo.module.resume.domain.entity.QResume;
import com.example.demo.module.resume.domain.entity.Resume;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
public class ResumeRepositoryExtensionImpl extends QuerydslRepositorySupport implements ResumeRepositoryExtension{
    public ResumeRepositoryExtensionImpl() {super(Resume.class);}

    public List<ResumeListDto> findMyResumeList(Account account) {
        QResume resume = QResume.resume;
        JPQLQuery<ResumeListDto> jpaQuery = from(resume)
                .where(resume.createdBy.eq(account))
                .select(new QResumeListDto(
                        resume.id, resume.title, resume.content, resume.createdBy.email.as("createdBy"),
                        resume.isOpened, resume.resumeHopedFields.any().firstField.id.as("firstWorkFieldId"),
                        resume.resumeHopedFields.any().secondField.id.as("secondWorkFieldId"),
                        resume.createdDate
                )).orderBy(resume.createdDate.desc());

        return jpaQuery.fetch();
    }
}
