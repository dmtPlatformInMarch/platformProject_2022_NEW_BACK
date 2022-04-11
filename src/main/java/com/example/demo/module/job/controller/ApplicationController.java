package com.example.demo.module.job.controller;

import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import com.example.demo.module.job.service.ApplicationService;
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
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping(value = "/application/new/byworker")
    public ApplicationDto createNewJobByWorker(@RequestBody ApplicationDto data) {
        System.out.println("create new applicaiton");
        ApplicationDto result = applicationService.createNewApplicationByWorker(data);
        return result;
    }

    //project/byworker
    @PostMapping(value = "/application/project/byworker")
    public ApplicationDto getApplicationsByWorker(@RequestBody ApplicationDto data) {
        System.out.println("get applicaiton by worker");
        ApplicationDto result = applicationService.getApplicationByWorker(data);
        return result;
    }

    //project/bymanager
    @PostMapping(value = "/application/project/bymanager")
    public List<ApplicationDto> getApplicationsByManager(@RequestBody ApplicationDto data) {
        System.out.println("get applicaiton by manager");
        List<ApplicationDto> result = applicationService.getApplicationsByManager(data);
        return result;
    }


    //project/byworker
    @PostMapping(value = "/application/change/byworker")
    public ApplicationDto changeApplicationByWorker(@RequestBody ApplicationDto data) {
        System.out.println("change applicaiton by worker");
        ApplicationDto result = applicationService.changeStatusByWorker(data);
        return result;
    }

    //project/bymanager
    @PostMapping(value = "/application/change/bymanager")
    public ApplicationDto changeApplicationByManager(@RequestBody ApplicationDto data) {
        System.out.println("change applicaiton by manager");
        ApplicationDto result = applicationService.changeStatusByManager(data);
        return result;
    }

    //project/bymanager
    @PostMapping(value = "/application/one")
    public ApplicationDto getApplication(@RequestBody ApplicationDto data) {
        System.out.println("get one application");
        ApplicationDto result = applicationService.getApplication(data);
        return result;
    }
}
