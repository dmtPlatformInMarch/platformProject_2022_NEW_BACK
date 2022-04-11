package com.example.demo.module.project.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.domain.entity.QAccount;
import com.example.demo.module.project.domain.dto.ProjectRegisterDto;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.dto.QProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import com.example.demo.module.project.domain.entity.QProjectSeries;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class ProjectSeriesRepositoryExtensionImpl extends QuerydslRepositorySupport implements ProjectSeriesRepositoryExtension {
    public ProjectSeriesRepositoryExtensionImpl() {
        super(ProjectSeries.class);
    }

    @Override
    public List<ProjectSeriesRegisterDto> findMySeriesAndOpened(Account account) {
        QProjectSeries series = QProjectSeries.projectSeries;

        JPQLQuery<ProjectSeriesRegisterDto> jpaQuery = from(series)
                .leftJoin(series.createdBy, QAccount.account)
                .where(series.createdBy.eq(account)
                        .or(series.isOpened.isTrue()))
                .select(new QProjectSeriesRegisterDto(
                        series.id, series.title, series.content, series.isOpened, QAccount.account.email.as("createdBy")
                )).distinct();

        return jpaQuery.fetch();
    }
    /*
    @Override
    public AccountAuthDto findByEmailWhenLogin(String email) {
        QAccount account = QAccount.account;
        JPQLQuery<AccountAuthDto> jpaQuery = from(account)
                .leftJoin(account.role, QRole.role)
                .where(account.email.eq(email))
                .select(new QAccountAuthDto(
                    account.email, account.password, account.firstName, account.lastName,
                        account.phoneNumber, QRole.role.roleName.as("roleName")
                ));

        return jpaQuery.fetchOne();
    }

    @Override
    public AccountRoleDto findRoleByEmail(String email) {
        QAccount account = QAccount.account;
        JPQLQuery<AccountRoleDto> jpaQuery = from(account)
                .leftJoin(account.role, QRole.role)
                .where(account.email.eq(email))
                .select(new QAccountRoleDto(
                        account.email, QRole.role.roleName.as("roleName")
                ));

        log.info("email : " + email);
        log.info("jpa query result : " + jpaQuery);
        return jpaQuery.fetchOne();
    }
     */
}
