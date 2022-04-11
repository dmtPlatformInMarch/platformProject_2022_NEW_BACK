package com.example.demo.module.account.repository;

import com.example.demo.module.account.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryExtension {
    Account findByEmail(String email);

    int countByEmail(String email);
    boolean existsByEmail(String email);
}
