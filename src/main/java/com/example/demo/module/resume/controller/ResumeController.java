package com.example.demo.module.resume.controller;

import com.example.demo.module.resume.domain.dto.ResumeDto;
import com.example.demo.module.resume.domain.dto.ResumeListDto;
import com.example.demo.module.resume.domain.entity.AbilitySource;
import com.example.demo.module.resume.domain.entity.ContactType;
import com.example.demo.module.resume.domain.entity.Resume;
import com.example.demo.module.resume.repository.AbilitySourceRepository;
import com.example.demo.module.resume.repository.ContactTypeRepository;
import com.example.demo.module.resume.service.AbilitySourceService;
import com.example.demo.module.resume.service.ContactTypeService;
import com.example.demo.module.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeController {
    private final ResumeService resumeService;
    private final AbilitySourceService abilitySourceService;
    private final ContactTypeService contactTypeService;

    @GetMapping(value = "/ability-source/all")
    public List<AbilitySource> getAllAbilitySources() {
        log.info("all ability");
        List<AbilitySource> result = abilitySourceService.getAllAbilitySources();
        return result;
    }

    @GetMapping(value = "/contact-type/all")
    public List<ContactType> getAllContactTypes() {
        log.info("all contactType");
        List<ContactType> result = contactTypeService.getAllContactTypes();
        return result;
    }

    @PostMapping(value = "/resume/new")
    public ResumeDto createNewResume(@RequestBody ResumeDto resumeForm) {
        log.info("new resume");
        ResumeDto result = resumeService.createNewResume(resumeForm);
        return result;
    }


    @PostMapping(value = "/resume/edit")
    public ResumeDto editMyResume(@RequestBody ResumeDto data) {
        log.info("resume one edit");
        ResumeDto result = resumeService.editResume(data);
        return result;
    }

    @PostMapping(value = "/resume/delete")
    public ResumeDto deleteMyResume(@RequestBody ResumeDto data) {
        log.info("resume one delete");
        ResumeDto result = resumeService.deleteResume(data);
        return result;
    }

    @PostMapping(value = "/resume/mine")
    public List<ResumeListDto> getMyResumes(@RequestBody ResumeListDto data){
        log.info("resume mine");
        List<ResumeListDto> result = resumeService.getMyResume(data.getCreatedBy());
        return result;
    }

    @PostMapping(value = "/resume")
    public ResumeDto getMyResume(@RequestBody ResumeDto data) {
        log.info("resume one get");
        ResumeDto result = resumeService.getResumeById(data.getId());
        return result;
    }

}
