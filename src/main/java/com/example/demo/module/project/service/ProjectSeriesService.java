package com.example.demo.module.project.service;

import com.example.demo.config.exception.exception.TitleAlreadyFoundException;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.project.domain.dto.ProjectListDto;
import com.example.demo.module.project.domain.dto.ProjectRegisterDto;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.project.repository.ProjectRepository;
import com.example.demo.module.project.repository.ProjectSeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectSeriesService {
    private final ProjectSeriesRepository projectSeriesRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public ProjectSeriesRegisterDto createNewSeries(ProjectSeriesRegisterDto seriesForm) {
        ProjectSeries newSeries = modelMapper.map(seriesForm, ProjectSeries.class);
        log.info("new series service");
        if(seriesForm.getCreatedBy() != null || !seriesForm.getCreatedBy().equals("")) {
            Account createdBy = accountRepository.findByEmail(seriesForm.getCreatedBy());
            log.info("createdBy = " + createdBy);
            newSeries.setCreatedBy(createdBy);
        }

        if(projectSeriesRepository.existsByTitle(seriesForm.getTitle())) {
            throw new TitleAlreadyFoundException("이미 존재하는 제목입니다.");
        }
        else {
            projectSeriesRepository.save(newSeries);
        }
        return seriesForm;
    }

    @Transactional
    public List<ProjectSeriesRegisterDto> getMineAndOpenedSeries(String createdBy) {
        Account account = accountRepository.findByEmail(createdBy);
        List<ProjectSeriesRegisterDto> projectSeriesList = projectSeriesRepository.findMySeriesAndOpened(account);
        return projectSeriesList;
    }
}
