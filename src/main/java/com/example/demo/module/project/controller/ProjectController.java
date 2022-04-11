package com.example.demo.module.project.controller;

import com.example.demo.module.account.domain.dto.AccountRegisterDto;
import com.example.demo.module.account.domain.dto.AccountRegisteredDto;
import com.example.demo.module.project.domain.dto.ProjectFieldListDto;
import com.example.demo.module.project.domain.dto.ProjectListDto;
import com.example.demo.module.project.domain.dto.ProjectRegisterDto;
import com.example.demo.module.project.domain.dto.ProjectSeriesRegisterDto;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.project.service.ProjectFieldService;
import com.example.demo.module.project.service.ProjectSeriesService;
import com.example.demo.module.project.service.ProjectService;
import com.example.demo.module.resume.domain.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectSeriesService projectSeriesService;
    private final ProjectFieldService projectFieldService;

    @PostMapping(value = "/series/new")
    public ProjectSeriesRegisterDto createProjectSeries(@RequestBody ProjectSeriesRegisterDto seriesForm) {

        log.info("series form");
        ProjectSeriesRegisterDto result = projectSeriesService.createNewSeries(seriesForm);

        return result;
    }

    @PostMapping(value = "/series/mine")
    public List<ProjectSeriesRegisterDto> getMyProjectSeries(@RequestBody ProjectSeriesRegisterDto data) {
        log.info("series mine api");
        List<ProjectSeriesRegisterDto> result = projectSeriesService.getMineAndOpenedSeries(data.getCreatedBy());
        return result;
    }


    @PostMapping(value = "/project/new")
    public ProjectRegisterDto createProject(@RequestBody ProjectRegisterDto projectForm) {
        log.info("project form");
        ProjectRegisterDto result = projectService.createNewProject(projectForm);

        return result;
    }

    @PostMapping(value = "/project/edit")
    public ProjectRegisterDto editMyResume(@RequestBody ProjectRegisterDto data) {
        log.info("project one edit");
        ProjectRegisterDto result = projectService.editProject(data);
        return result;
    }

    @PostMapping(value = "/project/all")
    public List<ProjectListDto> getProjects(@RequestBody ProjectListDto projectForm) {
        log.info("get all projects");
        List<ProjectListDto> result = projectService.getAllProjects(projectForm);
        return result;
    }

    @PostMapping(value = "/project/mine")
    public List<ProjectListDto> getMyProjects(@RequestBody ProjectListDto projectForm) {
        log.info("get my projects");
        List<ProjectListDto> result = projectService.getMyProjects(projectForm);
        return result;
    }

    @PostMapping(value = "/project/")
    public ProjectRegisterDto getProject(@RequestBody ProjectRegisterDto data) {
        log.info("get project one");
        log.info("data", data);
        ProjectRegisterDto result = projectService.getProject(data);
        return result;
    }

    @GetMapping(value = "/field/all")
    public List<ProjectFieldListDto> getAllProjectField() {
        List<ProjectFieldListDto> result = projectFieldService.getAllField();
        return result;
    }


    // 프로젝트 페이징 테스트
    // 내 프로젝트 목록
    /*
    @GetMapping("/tr/projects")
    public List<ProjectListDto> getMyProjects(@PageableDefault(size = 15, page = 0, sort = "createdDate",
                                        direction = Sort.Direction.DESC) Pageable pageable,
                                Model model, HttpRequest request) {




        //model.addAttribute("status", status);
        //model.addAttribute("category", category);
        //model.addAttribute("sortProperty", pageable.getSort().toString());

    }
     */

}
