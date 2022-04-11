package com.example.demo.module.project.service;

import com.example.demo.config.exception.exception.TitleAlreadyFoundException;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.project.domain.dto.ProjectFieldListDto;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.project.repository.ProjectSeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectFieldService {
    private final ProjectFieldRepository projectFieldRepository;

    @Transactional
    public List<ProjectFieldListDto> getAllField() {
        List<ProjectFieldListDto> result =  projectFieldRepository.findFieldsAll();
        return result;
    }
}
