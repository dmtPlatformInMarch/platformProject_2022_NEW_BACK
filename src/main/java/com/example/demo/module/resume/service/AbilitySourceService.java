package com.example.demo.module.resume.service;

import com.example.demo.module.resume.domain.entity.AbilitySource;
import com.example.demo.module.resume.repository.AbilitySourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AbilitySourceService {
    private final AbilitySourceRepository abilitySourceRepository;

    @Transactional
    public List<AbilitySource> getAllAbilitySources() {
        log.info("ability service");
        return abilitySourceRepository.findAll();
    }
}
