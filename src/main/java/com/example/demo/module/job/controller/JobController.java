package com.example.demo.module.job.controller;

import com.example.demo.module.job.domain.dto.JobApplicationDto;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import com.example.demo.module.job.domain.dto.JobListDto;
import com.example.demo.module.job.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {
    private final JobService jobService;

    @PostMapping(value = "/job/byproject")
    public List<JobListDto> fetchJobsByProject(@RequestBody JobListDto data) {
        System.out.println("get jobs by project");
        return jobService.getJobsByProject(data);
    }

    @PostMapping(value = "/job/byapplication")
    public List<JobListDto> fetchJobsByApplication(@RequestBody JobListDto data) {
        System.out.println("get jobs by application");
        return jobService.getJobsByApplication(data);
    }

    /*
    @PostMapping(value = "/job/new")
    public ApplicationDto createNewJob(@RequestBody ApplicationDto data) {
        log.info("create new job");
        ApplicationDto result = jobService.createNewJob(data);
        return result;
    }

    //작업 목록
    @PostMapping(value = "/job/")
    public List<JobListDto> getJobsByProject(@RequestBody ApplicationDto data) {
        log.info("get jobs by project");
        List<JobListDto> result = jobService.getJobsByProject(data);
        return result;
    }

    //지원 목록
    @PostMapping(value = "/job/manager/application")
    public List<JobListDto> getApplicationAsManager(@RequestBody ApplicationDto data) {
        log.info("controller: get all jobs by project as manager");
        log.info("data", data);
        List<JobListDto> result = jobService.getAllJobsByProjectAsManager(data);
        return result;
    }

    @PostMapping(value = "/job/worker/application")
    public List<JobApplicationDto> getApplicationAsWorker(@RequestBody ApplicationDto data) {
        log.info("controller: get all jobs by project as worker");
        log.info("data", data);
        List<JobApplicationDto> result = jobService.getAllJobsByProjectAsWorker(data);
        return result;
    }

    //withfiles
    @PostMapping(value = "/job/files")
    public List<JobListDto> getJobsWithFile(@RequestBody ApplicationDto data) {
        log.info("controller: get jobs with file");
        List<JobListDto> result = jobService.getJobsWithFile(data);
        return result;
    }
     */
}
