package com.example.demo.module.project.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.project.domain.dto.ProjectListDto;
import com.example.demo.module.project.domain.dto.QProjectListDto;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.QProject;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class ProjectRepositoryExtensionImpl extends QuerydslRepositorySupport implements ProjectRepositoryExtension {
    public ProjectRepositoryExtensionImpl() {
        super(Project.class);
    }

    @Override
    public List<ProjectListDto> findMyProjectsAsManager(Account createdBy) {
        QProject project = QProject.project;
        JPQLQuery<ProjectListDto> jpqlQuery = from(project)
                .where(project.createdBy.eq(createdBy))
                .select(new QProjectListDto( project.id,
                        project.title, project.content, project.firstField.fieldName.as("firstFieldName"),
                        project.createdDate, project.deadline, project.paymentType,
                        project.fixedPayment, project.toPayment, project.fromPayment,
                        project.favoriteCnt, project.isOpened, project.createdBy.email
                ))
                .orderBy(project.createdDate.desc());

        return jpqlQuery.fetch();
    }

    @Override
    public List<ProjectListDto> findMyProjectAsWorker(Account worker) {
        return null;
    }

    @Override
    public List<ProjectListDto> findAllProjectsAsManager() {
        log.info("respository");
        QProject project = QProject.project;
        JPQLQuery<ProjectListDto> jpqlQuery = from(project)
                .select(new QProjectListDto( project.id,
                        project.title, project.content, project.firstField.fieldName.as("firstFieldName"),
                        project.createdDate, project.deadline, project.paymentType,
                        project.fixedPayment, project.toPayment, project.fromPayment,
                        project.favoriteCnt, project.isOpened, project.createdBy.email
                ))
                .where(project.isOpened.isTrue())
                .orderBy(project.createdDate.desc());

        return jpqlQuery.fetch();
    }

    @Override
    public List<ProjectListDto> findAllProjectsAsWorker(){
        return null;
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
