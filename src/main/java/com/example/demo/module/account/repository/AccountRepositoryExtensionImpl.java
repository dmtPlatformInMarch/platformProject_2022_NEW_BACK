package com.example.demo.module.account.repository;

import com.example.demo.module.account.domain.dto.*;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.domain.entity.QAccount;
import com.example.demo.module.role.domain.entity.QRole;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Slf4j
public class AccountRepositoryExtensionImpl extends QuerydslRepositorySupport implements AccountRepositoryExtension{
    public AccountRepositoryExtensionImpl() {
        super(Account.class);
    }

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

    @Override
    public AccountAppDto findAccountWithApplication(String email) {
        QAccount account = QAccount.account;
        JPQLQuery<AccountAppDto> jpaQuery = from(account)
                .where(account.email.eq(email))
                .select(new QAccountAppDto(
                        account.id,
                        account.firstName,
                        account.lastName,
                        account.phoneNumber,
                        account.email,
                        account.role.roleName.as("roleName")
                ));

        return jpaQuery.fetchOne();
    }
}
