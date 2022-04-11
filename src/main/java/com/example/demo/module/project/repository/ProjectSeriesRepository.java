package com.example.demo.module.project.repository;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectSeriesRepository extends JpaRepository<ProjectSeries, Long>, ProjectSeriesRepositoryExtension {
   // Project findBy(String email);
   // int countByEmail(String email);
   // boolean existsByEmail(String email);
    List<ProjectSeries> findByCreatedBy(Account createor);
    boolean existsByTitle(String title);
}
