package com.example.demo.module.project.repository;

import com.example.demo.module.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryExtension {
   // Project findBy(String email);
    boolean existsByTitle(String title);
   // int countByEmail(String email);
   // boolean existsByEmail(String email);
}
