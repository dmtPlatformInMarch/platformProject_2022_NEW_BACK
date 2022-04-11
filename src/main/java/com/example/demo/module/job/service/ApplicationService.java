package com.example.demo.module.job.service;

import com.example.demo.config.exception.exception.ApplicationAlreadyFoundException;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.file.repository.CustomFileRepository;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.ApplicationStatus;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import com.example.demo.module.job.repository.ApplicationRepository;
import com.example.demo.module.job.repository.JobRepository;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.repository.ProjectRepository;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;
    private final ResumeRepository resumeRepository;
    private final CustomFileRepository customFileRepository;

    @Transactional
    //입력에 들어가야 하는 것 : project id, worker email, resume id, is worker applied
    public ApplicationDto createNewApplicationByWorker(ApplicationDto data) {
        System.out.println("create new application in service");
        System.out.println("data : " + data);

        Application newApplication = new Application();

        //project search
        Project project = new Project();
        if(data.getProjectId() != null) {
            project = projectRepository.getById(data.getProjectId());
            newApplication.setProject(project);
        }

        System.out.println("1");
        //worker search
        Account worker = new Account();
        if(data.getWorkerEmail() != null) {
            worker = accountRepository.findByEmail(data.getWorkerEmail());
            newApplication.setWorker(worker);
        }

        System.out.println("2");
        /* 한 프로젝트에는 중복된 worker id의 신청이 들어가선 안 된다 */
        if(applicationRepository.existsByProjectAndWorker(project, worker)) {
            System.out.println("exist");
            throw new ApplicationAlreadyFoundException("해당 프로젝트에 이미 지원한 작업자입니다.");
        }

        System.out.println("3");

        Resume resume = new Resume();
        if(data.getResumeId() != null) {
            resume = resumeRepository.getById(data.getResumeId());
            newApplication.setResume(resume);
        }

        System.out.println("4");

        if(data.isWorkerApplied()) { //worker가 apply한 것이라면
            newApplication.setWorkerApplied(true);
            newApplication.setApplicationStatus(ApplicationStatus.WorkerApplied);
        }
        else {
            newApplication.setWorkerApplied(false);
            newApplication.setApplicationStatus(ApplicationStatus.ManagerApplied);
        }

        System.out.println("5");

        Account manager = accountRepository.findById(project.getCreatedBy().getId()).get();
        newApplication.setManager(manager);

        newApplication.setApplicationContent(data.getApplicationContent());

        System.out.println("6");

        Application application = applicationRepository.save(newApplication);
        project.addApplication(application);
        return data;
    }


    @Transactional
    public ApplicationDto getApplicationByWorker(ApplicationDto data) {
        System.out.println("get application by worker");
        System.out.println("data : " + data);

        //project id, worker email
        Account worker = accountRepository.findByEmail(data.getWorkerEmail());
        Project project = projectRepository.findById(data.getProjectId()).get();

        return applicationRepository.findAppByWorkerByProjectAndWorker(
                project, worker
        );
    }

    @Transactional
    public List<ApplicationDto> getApplicationsByManager(ApplicationDto data) {
        System.out.println("get applications by manager");
        System.out.println("data : " + data);

        //project id, worker email
        Account manager = accountRepository.findByEmail(data.getManagerEmail());
        Project project = projectRepository.findById(data.getProjectId()).get();

        return applicationRepository.findAppByManagerByProject(
                project, manager
        );
    }


    private final ModelMapper modelMapper;

    @Transactional
    public ApplicationDto changeStatusByWorker(ApplicationDto data) {
        System.out.println("data : " + data);
        Application application = applicationRepository.getById(data.getId());
        /*

        ManagerApplied, WorkerApplied,
    ManagerAppliedAndWorkerConfirmed,
    WorkerAppliedAndManagerConfirmed,
    ManagerAppliedAndWorkerCanceled,
    WorkerAppliedAndManagerCanceled
         */

        if(application.getApplicationStatus().equals(ApplicationStatus.ManagerApplied)) {
            application.setApplicationStatus(ApplicationStatus.ManagerAppliedAndWorkerCanceled);
        }

        if(application.getApplicationStatus().equals(ApplicationStatus.WorkerApplied))
            application.setApplicationStatus(ApplicationStatus.WorkerAppliedAndWorkerCanceled);

        applicationRepository.save(application);
        data = modelMapper.map(application, ApplicationDto.class);
        return data;
    }


    @Transactional
    public ApplicationDto changeStatusByManager(ApplicationDto data) {
        System.out.println("data : " + data);
        Application application = applicationRepository.getById(data.getId());

        /*

        ManagerApplied, WorkerApplied,
    ManagerAppliedAndWorkerConfirmed,
    WorkerAppliedAndManagerConfirmed,
    ManagerAppliedAndWorkerCanceled,
    WorkerAppliedAndManagerCanceled
         */


        if(application.getApplicationStatus().equals(ApplicationStatus.WorkerApplied))
            application.setApplicationStatus(ApplicationStatus.WorkerAppliedAndManagerCanceled);

        if(application.getApplicationStatus().equals(ApplicationStatus.ManagerApplied))
            application.setApplicationStatus(ApplicationStatus.ManagerAppliedAndManagerCanceled);


        applicationRepository.save(application);
        data = modelMapper.map(application, ApplicationDto.class);
        return data;
    }

    @Transactional
    public ApplicationDto getApplication(ApplicationDto data) {
        System.out.println("get application");
        System.out.println("data : " + data);

        ApplicationDto application = applicationRepository.getOneById(data.getId());
        return application;
    }

}
