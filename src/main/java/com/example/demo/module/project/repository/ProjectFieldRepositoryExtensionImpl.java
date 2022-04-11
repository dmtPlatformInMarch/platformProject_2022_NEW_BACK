package com.example.demo.module.project.repository;

import com.example.demo.module.project.domain.dto.ProjectFieldListDto;
import com.example.demo.module.project.domain.dto.QProjectFieldListDto;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.domain.entity.QProjectField;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class ProjectFieldRepositoryExtensionImpl extends QuerydslRepositorySupport implements ProjectFieldRepositoryExtension {
    public ProjectFieldRepositoryExtensionImpl() {
        super(ProjectField.class);
    }

    @Override
    public List<ProjectFieldListDto> findFieldsAll() {
        QProjectField field = QProjectField.projectField;

        JPQLQuery<ProjectFieldListDto> jpaQuery = from(field)
                .select(new QProjectFieldListDto(
                        field.id, field.fieldName, field.parentProjectField.id.as("parentId"), field.depth
                ));

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
