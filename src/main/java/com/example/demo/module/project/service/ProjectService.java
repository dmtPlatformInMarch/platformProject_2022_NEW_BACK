package com.example.demo.module.project.service;

import com.example.demo.config.exception.exception.ProjectNotFoundException;
import com.example.demo.config.exception.exception.TitleAlreadyFoundException;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.repository.CustomFileRepository;
import com.example.demo.module.job.repository.ApplicationRepository;
import com.example.demo.module.job.repository.JobRepository;
import com.example.demo.module.project.domain.dto.ProjectListDto;
import com.example.demo.module.project.domain.dto.ProjectRegisterDto;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.domain.entity.ProjectSeries;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.project.repository.ProjectRepository;
import com.example.demo.module.project.repository.ProjectSeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectSeriesRepository projectSeriesRepository;
    private final ProjectFieldRepository projectFieldRepository;
    private final AccountRepository accountRepository;
    private final CustomFileRepository customFileRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;

    //getAllProjects
    @Transactional
    public List<ProjectListDto> getAllProjects(ProjectListDto data) {
        Account account = accountRepository.findByEmail(data.getCreatedBy());

        log.info("get all projects service");
        log.info("data : ", data);
        log.info(account.getRole().getRoleName());

        List<ProjectListDto> result = new ArrayList<>();

        if(account.getRole().getRoleName() != "ROLE_WORKER")
            result = projectRepository.findAllProjectsAsManager();
        else
            result = projectRepository.findAllProjectsAsWorker();

        log.info("before result");

        return result;
    }

    @Transactional
    public List<ProjectListDto> getMyProjects(ProjectListDto data) {
        Account account = accountRepository.findByEmail(data.getCreatedBy());
        List<ProjectListDto> result = new ArrayList<>();

        if(account.getRole().getRoleName() != "ROLE_WORKER")
            result = projectRepository.findMyProjectsAsManager(account);
        else
            result = projectRepository.findMyProjectsAsManager(account);

        return result;
    }

    @Transactional
    public ProjectRegisterDto createNewProject(ProjectRegisterDto projectForm) {
        Project newProject = modelMapper.map(projectForm, Project.class);

        log.info("In create new project");
        log.info("projectForm : " + projectForm);
        log.info("account: " + projectForm.getCreatedBy());

        //field setting
        if(!projectForm.getFirstField().isEmpty()) {
            ProjectField firstField = projectFieldRepository.getById(Long.parseLong(projectForm.getFirstField()));
            newProject.setFirstField(firstField);
        }
        if(!projectForm.getSecondField().isEmpty()) {
            ProjectField secondField = projectFieldRepository.getById(Long.parseLong(projectForm.getSecondField()));
            newProject.setSecondField(secondField);
        }
        if(!projectForm.getThirdField().isEmpty()) {
            ProjectField thirdField = projectFieldRepository.getById(Long.parseLong(projectForm.getThirdField()));
            newProject.setThirdField(thirdField);
        }
        //series setting
        if(!(projectForm.getSeries().isEmpty())) {
            //if series info exists
            ProjectSeries projectSeries = projectSeriesRepository.getById(Long.parseLong(projectForm.getSeries()));
            projectSeries.addProject(newProject);
            newProject.setProjectSeries(projectSeries);
        }

        Account account = accountRepository.findByEmail(projectForm.getCreatedBy());
        newProject.setCreatedBy(account);

        if(projectRepository.existsByTitle(projectForm.getTitle())) {
            log.info("here");
            throw new TitleAlreadyFoundException("이미 존재하는 제목입니다.");
        }
        else {
            projectRepository.save(newProject);
        }
        log.info("account: " + account);

        projectForm.setId(newProject.getId());
        return projectForm;
    }

    @Transactional
    public ProjectRegisterDto editProject(ProjectRegisterDto projectForm) {
        if(!projectRepository.existsById(projectForm.getId())) {
            throw new ProjectNotFoundException("해당하는 프로젝트를 찾을 수 없습니다.");
        }
        System.out.println("id : " + projectForm.getId());
        Project project = projectRepository.getById(projectForm.getId());
        project = modelMapper.map(projectForm, Project.class);


        log.info("In create new project");
        log.info("projectForm : " + projectForm);
        log.info("account: " + projectForm.getCreatedBy());
        System.out.println(projectForm);
        //field setting
        if(projectForm.getFirstField() != null) {
            ProjectField firstField = projectFieldRepository.getById(Long.parseLong(projectForm.getFirstField()));
            project.setFirstField(firstField);
        }
        if(projectForm.getSecondField()  != null ) {
            ProjectField secondField = projectFieldRepository.getById(Long.parseLong(projectForm.getSecondField()));
            project.setSecondField(secondField);
        }
        if(projectForm.getThirdField() != null) {
            ProjectField thirdField = projectFieldRepository.getById(Long.parseLong(projectForm.getThirdField()));
            project.setThirdField(thirdField);
        }
        System.out.println("1");
        //series setting
        if(projectForm.getSeries() != null) {
            //if series info exists
            ProjectSeries projectSeries = projectSeriesRepository.getById(Long.parseLong(projectForm.getSeries()));
            projectSeries.addProject(project);
            project.setProjectSeries(projectSeries);
        }
        System.out.println("2");
        if(project.getProjectSeries() != null) {
            ProjectSeries projectSeries = projectSeriesRepository.getById(project.getProjectSeries().getId());
            projectSeries.removeProject(project);
        }
        Account account = accountRepository.findByEmail(projectForm.getCreatedBy());
        project.setCreatedBy(account);


        System.out.println("3");
        if(projectRepository.existsByTitle(projectForm.getTitle()) &&
            project.getTitle() != projectForm.getTitle()) {
            log.info("here");
            throw new TitleAlreadyFoundException("이미 존재하는 제목입니다.");
        }
        else {
            projectRepository.save(project);
        }


        System.out.println("4");
        projectForm.setId(project.getId());
        return projectForm;
    }

    @Transactional
    public ProjectRegisterDto getProject(ProjectRegisterDto form) {
        log.info("id : " + form.getId());
        log.info("email : " + form.getUserEmail());
        String userEmail = form.getUserEmail();
        if(!projectRepository.existsById(form.getId()))
            throw new ProjectNotFoundException("존재하지 않는 프로젝트입니다.");

        Project project = projectRepository.getById(form.getId());

        form = modelMapper.map(project, ProjectRegisterDto.class);
        if(project.getCreatedDate() != null)
            form.setCreatedDate(project.getCreatedDate());

        if(project.getFirstField() != null) {
            form.setFirstField(project.getFirstField().getFieldName());
            form.setFirstFieldId(project.getFirstField().getId());
        }
        if(project.getSecondField() != null) {
            form.setSecondField(project.getSecondField().getFieldName());
            form.setSecondFieldId(project.getSecondField().getId());
        }
        if(project.getThirdField() != null) {
            form.setThirdField(project.getThirdField().getFieldName());
            form.setThirdFieldId(project.getThirdField().getId());
        }

        form.setCreatedBy(project.getCreatedBy().getEmail());

        if(project.getProjectSeries() != null) {
            form.setSeries(project.getProjectSeries().getId().toString());
            form.setSeriesTitle(project.getProjectSeries().getTitle());
        }

        List<CustomFile> customFiles = new ArrayList<>();
        if(!customFileRepository.existsByObjectCodeAndObjectType(project.getId(), "project")) {
            form.setFileCnt(0);
        }
        else {
            customFiles = customFileRepository.findByObjectCodeAndObjectType(project.getId(), "project");
            form.setFileCnt(customFiles.size());
            form.setFiles(customFiles);
        }

        //applied
        Account account = accountRepository.findByEmail(userEmail);
        System.out.println("account2: " + account);
        System.out.println(account.getRole().getRoleName());

        //worker인 경우 해당 프로젝트에 참여하고 있는지 여부도 알아야 함!!!!
        if(account.getRole().getRoleName().equals("ROLE_WORKER")) {
            System.out.println("role worker here");
            if(applicationRepository.existsByProjectAndWorker(project, account))
                form.setApplied(true);
            else
                form.setApplied(false);
            System.out.println("form applied : " + form.isApplied());
        }
        return form;
    }
}
