package com.example.demo.module.job.repository;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import com.example.demo.module.job.domain.dto.JobApplicationDto;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.project.domain.entity.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ApplicationRepositoryExtension {
    /*
    List<JobListDto> findByProjectId(Project project);
    List<JobListDto> findByProjectIdAndWorkerId(Project project, Account worker);
    List<JobListDto> getAllApplicationAsManager(Project project, Account manager);
    List<JobApplicationDto> getApplicationAsWorker(Project project, Account worker);
    List<JobListDto> findByProjectIdAndManagerId(Project project, Account manager);
    List<JobListDto> getAllApplicationAsWorker(Project project, Account worker);

     */

    ApplicationDto findAppByWorkerByProjectAndWorker(Project project, Account worker);
    List<ApplicationDto> findAppByManagerByProject(Project project, Account manager);
    ApplicationDto getOneById(Long id);
}
