package com.example.demo.module.job.service;

import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.repository.CustomFileRepository;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.domain.Job;
import com.example.demo.module.job.domain.domain.JobStatus;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.job.repository.ApplicationRepository;
import com.example.demo.module.job.repository.JobRepository;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.repository.ProjectRepository;
import com.example.demo.module.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobService {
    private final JobRepository jobRepository;
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;
    private final ResumeRepository resumeRepository;
    private final CustomFileRepository customFileRepository;


    @Transactional
    public Job createNewJob(Application app, CustomFile customFile) {
        Job job = new Job();
        job.setApplication(app);
        app.addJob(job);

        Project project = projectRepository.getById(app.getProject().getId());
        job.setProject(project);

        job.setCustomFile(customFile);

        job.setJobStatus(JobStatus.WorkerProcessing);

        return jobRepository.save(job);
    }

    @Transactional
    public List<JobListDto> getJobsByProject(JobListDto data) {
        System.out.println("get jobs by project");
        System.out.println("data : " + data);
        Project project = projectRepository.getById(data.getProjectId());
        return jobRepository.findJobsByProject(project);
    }

    private final ApplicationRepository applicationRepository;

    //worker email, project id
    @Transactional
    public List<JobListDto> getJobsByApplication(JobListDto data) {
        System.out.println("get jobs by project");
        System.out.println("data : " + data);
        Account worker = accountRepository.findByEmail(data.getWorkerEmail());
        Project project = projectRepository.findById(data.getProjectId()).get();
        Application application = applicationRepository.findByProjectAndWorker(project, worker);

        return jobRepository.findJobsByApplication(application);
    }
    /*
    @Transactional
    public ApplicationDto createNewJob(JobListDto data) {
        log.info("data : " + data);
        log.info("create new job");
        System.out.println("data : " + data);
        Job newJob = new Job();
        Project project = new Project();

        if(data.getProjectId() != null) {
            project = projectRepository.getById(data.getProjectId());
            newJob.setProject(project);
        }
        log.info("project : " + project);

        Resume resume = new Resume();
        if(data.getResumeId() != null) {
            resume = resumeRepository.getById(data.getResumeId());
            newJob.setResume(resume);
        }

        log.info("resume : " + resume);

        if(data.isWorkerApplied()) {
            newJob.setWorkerApplied(true);
            newJob.setJobStatus(ApplicationStatus.WorkerApplied);
            Account worker = accountRepository.findByEmail(data.getUserEmail());
            newJob.setWorker(worker);
        }
        else {
            newJob.setWorkerApplied(false);
            newJob.setJobStatus(ApplicationStatus.ManagerApplied);
        }

        log.info("1");
        Account manager = accountRepository.findById(project.getCreatedBy().getId()).get();
        newJob.setManager(manager);

        newJob.setApplicationContent(data.getApplicationContent());


        Job job = jobRepository.save(newJob);
        project.addJob(job);
        return data;
    }

    @Transactional
    public List<JobListDto> getJobsByProject(ApplicationDto data) {
        Project project = new Project();

        List<JobListDto> result = null;

        if(data.getProjectId() != null) {
            if(projectRepository.existsById(data.getProjectId()))
            {
                project = projectRepository.getById(data.getProjectId());
                result = jobRepository.findByProjectId(project);
            }

        }

        return result;
    }

    //getAllJobsByProject
    @Transactional
    public List<JobListDto> getAllJobsByProjectAsManager(ApplicationDto data) {
        log.info("service : get all jobs by project as manager");
        log.info("data " + data.getProjectId());
        log.info("data " + data.getUserEmail());

        Project project = new Project();

        List<JobListDto> result = null;

        if(data.getProjectId() != null) {
            System.out.println("searching project : " + data.getProjectId());
            project = projectRepository.getById(data.getProjectId());
        }

        System.out.println("project : " + project.getId());

        Account account = accountRepository.findByEmail(data.getUserEmail());

        System.out.println("account : " + account.getId());

        //createdManager
        if(account.getEmail() == project.getCreatedBy().getEmail()) {
            log.info("created manager");
            result = jobRepository.getAllApplicationAsManager(project, account);
        }

        System.out.println(result);
        System.out.println(result.size());
        return result;
    }


    //getAllJobsByProject
    @Transactional
    public List<JobApplicationDto> getAllJobsByProjectAsWorker(ApplicationDto data) {
        log.info("service : get all jobs by project as worker");
        log.info("data " + data.getProjectId());
        log.info("data " + data.getUserEmail());

        Project project = new Project();

        List<JobApplicationDto> result = null;

        if(data.getProjectId() != null) {
            if(projectRepository.existsById(data.getProjectId()))
                project = projectRepository.getById(data.getProjectId());
            else throw new ProjectNotFoundException("존재하지 않는 프로젝트입니다.");
        }

        Account account = accountRepository.findByEmail(data.getUserEmail());


        //appliedWorker
        if(account.getRole().getRoleName().equals("ROLE_WORKER")) {
            System.out.println("get jobs as role worker");
            result = jobRepository.getApplicationAsWorker(project, account);
        }

        System.out.println(result);
        return result;
    }



    //getJobsWithFile
    @Transactional
    public List<JobListDto> getJobsWithFile(ApplicationDto data) {
        System.out.println("get jobs with file in service");
        Project project = new Project();

        List<JobListDto> result = null;

        if(data.getProjectId() != null) {
           // if(projectRepository.existsById(data.getProjectId()))
                project = projectRepository.getById(data.getProjectId());
           // else throw new ProjectNotFoundException("존재하지 않는 프로젝트입니다.");
        }

        System.out.println("get jobs with file in service, after project");
        System.out.println("get jobs with file in service, project : " + project.getId());

        System.out.println("get jobs with file in service, account email : " + data.getUserEmail());

        Account account = accountRepository.findByEmail(data.getUserEmail());

        System.out.println("get jobs with file in service, account : " + account);
        //참여 중인 worker일 때
        if(account.getRole().getRoleName().equals("ROLE_WORKER")) {
            result = jobRepository.getAllApplicationAsWorker(project, account);
            System.out.println("result : " + result.size());
            for(JobListDto r : result) {
                System.out.println("r : " + r);
                List<CustomFile> file = customFileRepository.findByObjectCodeAndObjectType(r.getId(), "Job");
                if(file.size() > 0) {
                    r.setFileId(file.get(0).getId());
                    r.setFileName(file.get(0).getOriginalName());
                }
            }
            System.out.println("file result : " + result);

        }
        else {
            result = jobRepository.getAllApplicationAsManager(project, account);
            System.out.println("result : " + result.size());
            for(JobListDto r : result) {
                List<CustomFile> file = customFileRepository.findByObjectCodeAndObjectType(r.getId(), "job");
                if(file.size() > 0) {
                    r.setFileId(file.get(0).getId());
                    r.setFileName(file.get(0).getOriginalName());
                }
            }
            System.out.println("file result : " + result);

        }

        return result;
    }
*/



}
