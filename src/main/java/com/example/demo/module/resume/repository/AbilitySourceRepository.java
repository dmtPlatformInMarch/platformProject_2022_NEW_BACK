package com.example.demo.module.resume.repository;

import com.example.demo.module.resume.domain.entity.AbilitySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitySourceRepository extends JpaRepository<AbilitySource, Long> {
    AbilitySource findByAbilityType(String abilityType);
}
