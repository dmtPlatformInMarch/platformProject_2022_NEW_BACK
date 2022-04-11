package com.example.demo.module.resume.service;

import com.example.demo.config.exception.exception.ResumeExcessException;
import com.example.demo.config.exception.exception.ResumeNotFountException;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.resume.domain.dto.*;
import com.example.demo.module.resume.domain.entity.*;
import com.example.demo.module.resume.repository.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final AccountRepository accountRepository;

    private final AbilitySourceRepository abilitySourceRepository;
    private final ContactTypeRepository contactTypeRepository;

    private final ResumeAbilityRepository resumeAbilityRepository;
    private final ResumeAcademyRepository resumeAcademyRepository;
    private final ResumeAdditionalContactRepository resumeAdditionalContactRepository;
    private final ResumeCertificateRepository resumeCertificateRepository;
    private final ResumeHopedFieldRepository resumeHopedFieldRepository;
    private final ProjectFieldRepository projectFieldRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public ResumeDto getResumeById(Long resumeId) {
        if(!resumeRepository.existsById(resumeId)) {
            throw new ResumeNotFountException("해당하는 이력서를 찾을 수 없습니다.");
        }

        Resume resume = resumeRepository.getById(resumeId);
        ResumeDto resumeForm = modelMapper.map(resume, ResumeDto.class);
        resumeForm.setCreatedBy(resume.getCreatedBy().getEmail());

        //resume ability
        List<ResumeAbility> resumeAbilities = resumeAbilityRepository.findByResume(resume);
        List<ResumeAbilityDto> resumeAbilityDtos = new ArrayList<>();
        if(!resumeAbilities.isEmpty()) {
            for (ResumeAbility resumeAbility : resumeAbilities) {
                ResumeAbilityDto resumeAbilityDto = ResumeAbilityDto.builder()
                        .id(resumeAbility.getId())
                        .resumeId(resume.getId())
                        .abilitySourceId(resumeAbility.getAbilitySource().getId())
                        .abilityType(resumeAbility.getAbilitySource().getAbilityType())
                        .desc(resumeAbility.getAbilityDesc()).build();
                resumeAbilityDtos.add(resumeAbilityDto);
            }
        }
        resumeForm.setResumeAbilityDtos(resumeAbilityDtos);


        //resume academy
        List<ResumeCertificate> resumeCertificates = resumeCertificateRepository.findByResume(resume);
        List<ResumeCertificateDto> resumeCertificateDtos = new ArrayList<>();
        if(!resumeCertificates.isEmpty()) {
            for (ResumeCertificate resumeCertificate : resumeCertificates) {
                ResumeCertificateDto resumeCertificateDto = ResumeCertificateDto.builder()
                        .id(resumeCertificate.getId())
                        .resumeId(resume.getId())
                        .certificateName(resumeCertificate.getCertificateName())
                        .grade(resumeCertificate.getGrade()).build();
                resumeCertificateDtos.add(resumeCertificateDto);
            }
        }
        resumeForm.setResumeCertificateDtos(resumeCertificateDtos);

        //Resue Academy
        List<ResumeAcademy> resumeAcademies = resumeAcademyRepository.findByResume(resume);
        List<ResumeAcademyDto> resumeAcademyDtos = new ArrayList<>();
        if(!resumeAcademies.isEmpty()) {
            for (ResumeAcademy resumeAcademy : resumeAcademies) {
                ResumeAcademyDto resumeAcademyDto = ResumeAcademyDto.builder()
                        .id(resumeAcademy.getId())
                        .resumeId(resume.getId())
                        .schoolName(resumeAcademy.getSchoolName())
                        .schoolType(resumeAcademy.getSchoolType())
                        .majorOrDesc(resumeAcademy.getMajorOrDesc()).build();
                resumeAcademyDtos.add(resumeAcademyDto);
            }
        }
        resumeForm.setResumeAcademyDtos(resumeAcademyDtos);

        //REsumeAdditionalContact
        List<ResumeAdditionalContact> resumeAdditionalContacts = resumeAdditionalContactRepository.findByResume(resume);
        List<ResumeAdditionalContactDto> resumeAdditionalContactDtos = new ArrayList<>();
        if(!resumeAdditionalContacts.isEmpty()) {
            for (ResumeAdditionalContact resumeAdditionalContact : resumeAdditionalContacts) {
                ResumeAdditionalContactDto resumeAdditionalContactDto = ResumeAdditionalContactDto.builder()
                        .id(resumeAdditionalContact.getId())
                        .resumeId(resume.getId())
                        .contact(resumeAdditionalContact.getContact())
                        .contactType(resumeAdditionalContact.getContactType().getContactType())
                        .contactTypeId(resumeAdditionalContact.getContactType().getId()).build();
                resumeAdditionalContactDtos.add(resumeAdditionalContactDto);
            }
        }
        resumeForm.setResumeAdditionalContactDtos(resumeAdditionalContactDtos);

        //ResumeHopedField
        List<ResumeHopedField> resumeHopedFields = resumeHopedFieldRepository.findByResume(resume);
        List<ResumeHopedFieldDto> resumeHopedFieldDtos = new ArrayList<>();
        if(!resumeHopedFields.isEmpty()) {
            for (ResumeHopedField resumeHopedField : resumeHopedFields) {
                ResumeHopedFieldDto resumeHopedFieldDto = ResumeHopedFieldDto.builder()
                        .id(resumeHopedField.getId())
                        .resumeId(resume.getId())
                        .firstFieldId(resumeHopedField.getFirstField().getId())
                        .firstFieldType(resumeHopedField.getFirstField().getFieldName())
                        .secondFieldId(resumeHopedField.getSecondField().getId())
                        .secondFieldType(resumeHopedField.getSecondField().getFieldName())
                        .build();
                resumeHopedFieldDtos.add(resumeHopedFieldDto);
            }
        }
        resumeForm.setResumeHopedFieldDtos(resumeHopedFieldDtos);


        return resumeForm;
    }

    @Transactional
    public List<ResumeListDto> getMyResume(String email) {
        log.info("email : " + email);
        Account createdBy = accountRepository.findByEmail(email);
        List<ResumeListDto> result = resumeRepository.findMyResumeList(createdBy);
        return result;
    }


    @Transactional
    public ResumeDto createNewResume(ResumeDto resumeForm) {
        log.info("in create new resume ");
        log.info("resumeForm : " + resumeForm);

        Resume newResume = new Resume();

        newResume.setTitle(resumeForm.getTitle());
        newResume.setContent(resumeForm.getContent());

        log.info("get place : " + resumeForm.getHopedWorkingPlace());
        //선택적 이력서 내용 채우기
        if(!resumeForm.getHopedWorkingPlace().isEmpty())
            newResume.setHopedWorkingPlace(resumeForm.getHopedWorkingPlace());

        log.info("after get place");

        if(!resumeForm.getHopedWorkingPeriod().isEmpty())
            newResume.setHopedWorkingPeriod(resumeForm.getHopedWorkingPeriod());

        log.info("after get period");


        log.info("1");
        //작성자 채우기
        Account createdBy = accountRepository.findByEmail(resumeForm.getCreatedBy());
        newResume.setCreatedBy(createdBy);
        newResume.setOpened(resumeForm.isOpened());
        createdBy.incrementResumeCnt();
        accountRepository.save(createdBy);
        //이력서는 5개까지만 만들 수 있음
        if(createdBy.getResumeCnt() >= 5)
            throw new ResumeExcessException("만들 수 있는 이력서 수를 초과했습니다.");

        newResume.incrementHopedFieldCnt();
        newResume = resumeRepository.save(newResume);


        log.info("2");
        //ResumeAbility
        if(!resumeForm.getResumeAbilityDtos().isEmpty()) {
            for (ResumeAbilityDto resumeAbilityDto : resumeForm.getResumeAbilityDtos()) {
                ResumeAbility resumeAbility = new ResumeAbility();

                AbilitySource abilitySource = abilitySourceRepository.findById(resumeAbilityDto.getAbilitySourceId()).get();
                resumeAbility.setAbilitySource(abilitySource);

                if(!resumeAbilityDto.getDesc().isEmpty())
                    resumeAbility.setAbilityDesc(resumeAbilityDto.getDesc());

                resumeAbility.setResume(newResume);
                newResume.addResumeAbilityList(resumeAbility);

                resumeAbilityRepository.save(resumeAbility);
                log.info("resumeAbility : " + resumeAbility);
            }
        }

        log.info("3");
        //ResumeAcademy
        if(!resumeForm.getResumeAcademyDtos().isEmpty()) {
            for (ResumeAcademyDto resumeAcademyDto : resumeForm.getResumeAcademyDtos()) {
                ResumeAcademy resumeAcademy = new ResumeAcademy();

                if(!resumeAcademyDto.getSchoolType().isEmpty())
                    resumeAcademy.setSchoolType(resumeAcademyDto.getSchoolType());

                if(!resumeAcademyDto.getSchoolName().isEmpty())
                    resumeAcademy.setSchoolName(resumeAcademyDto.getSchoolName());

                if(!resumeAcademyDto.getMajorOrDesc().isEmpty())
                    resumeAcademy.setMajorOrDesc(resumeAcademyDto.getMajorOrDesc());

                resumeAcademy.setResume(newResume);
                newResume.addResumeAcademyList(resumeAcademy);

                resumeAcademyRepository.save(resumeAcademy);
                log.info("resumeAcademy: " + resumeAcademy);
            }
        }

        //Resume Additional Contact
        if(!resumeForm.getResumeAdditionalContactDtos().isEmpty()) {
            for (ResumeAdditionalContactDto resumeAdditionalContactDto : resumeForm.getResumeAdditionalContactDtos()) {
                ResumeAdditionalContact resumeAdditionalContact = new ResumeAdditionalContact();

                ContactType contactType = contactTypeRepository.getById(resumeAdditionalContactDto.getContactTypeId());
                resumeAdditionalContact.setContactType(contactType);

                if(!resumeAdditionalContactDto.getContact().isEmpty())
                    resumeAdditionalContact.setContact(resumeAdditionalContactDto.getContact());

                resumeAdditionalContact.setResume(newResume);
                newResume.addResumeAdditionalContactList(resumeAdditionalContact);

                resumeAdditionalContactRepository.save(resumeAdditionalContact);
                log.info("resumeAdditionalContact : " + resumeAdditionalContact);
            }
        }

        //Resume Certificate
        if(!resumeForm.getResumeCertificateDtos().isEmpty()) {
            for (ResumeCertificateDto resumeCertificateDto : resumeForm.getResumeCertificateDtos()) {
                ResumeCertificate resumeCertificate = new ResumeCertificate();

                if(!resumeCertificateDto.getCertificateName().isEmpty())
                    resumeCertificate.setCertificateName(resumeCertificateDto.getCertificateName());

                if(!resumeCertificateDto.getGrade().isEmpty())
                    resumeCertificate.setGrade(resumeCertificateDto.getCertificateName());

                resumeCertificate.setResume(newResume);
                newResume.addResumeCertificateList(resumeCertificate);

                resumeCertificateRepository.save(resumeCertificate);
                log.info("resumeCertificate : " + resumeCertificate);
            }
        }

        //Resume Hoped Field
        if(!resumeForm.getResumeHopedFieldDtos().isEmpty()) {
            for (ResumeHopedFieldDto resumeHopedFieldDto : resumeForm.getResumeHopedFieldDtos()) {
                ResumeHopedField resumeHopedField = new ResumeHopedField();

                ProjectField firstField = projectFieldRepository.getById(resumeHopedFieldDto.getFirstFieldId());
                ProjectField secondField = projectFieldRepository.getById(resumeHopedFieldDto.getSecondFieldId());
                resumeHopedField.setFirstField(firstField);
                resumeHopedField.setSecondField(secondField);

                resumeHopedField.setResume(newResume);
                newResume.addResumeHopedFieldList(resumeHopedField);

                resumeHopedFieldRepository.save(resumeHopedField);
                log.info("resumeHopedField : " + resumeHopedField);
            }
        }

        return resumeForm;
    }

    @Transactional
    public ResumeDto editResume(ResumeDto resumeForm) {
        log.info("in edit resume");
        log.info("resume id : " + resumeForm.getId());
        log.info("resume form : " + resumeForm);
        if(!resumeRepository.existsById(resumeForm.getId())) {
            throw new ResumeNotFountException("해당하는 이력서를 찾을 수 없습니다.");
        }

        Resume resume = resumeRepository.getById(resumeForm.getId());

        resume.setTitle(resumeForm.getTitle());
        resume.setContent(resumeForm.getContent());

        log.info("get place : " + resumeForm.getHopedWorkingPlace());
        //선택적 이력서 내용 채우기
        if(resumeForm.getHopedWorkingPlace() != null)
            resume.setHopedWorkingPlace(resumeForm.getHopedWorkingPlace());

        log.info("after get place");

        if(resumeForm.getHopedWorkingPeriod() != null)
            resume.setHopedWorkingPeriod(resumeForm.getHopedWorkingPeriod());

        resumeRepository.save(resume);

        log.info("after get period");

        //ResumeAbility
        //기존에 있던 것 지우고
        List<ResumeAbility> resumeAbilities = resumeAbilityRepository.findByResume(resume);
        if(!resumeAbilities.isEmpty()) {
            for(ResumeAbility resumeAbility : resumeAbilities) {
                resumeAbilityRepository.delete(resumeAbility);
            }
        }

        //새로 추가하기
        if(!resumeForm.getResumeAbilityDtos().isEmpty()) {
            for (ResumeAbilityDto resumeAbilityDto : resumeForm.getResumeAbilityDtos()) {
                ResumeAbility resumeAbility = new ResumeAbility();

                AbilitySource abilitySource = abilitySourceRepository.findById(resumeAbilityDto.getAbilitySourceId()).get();
                resumeAbility.setAbilitySource(abilitySource);

                if(!resumeAbilityDto.getDesc().isEmpty())
                    resumeAbility.setAbilityDesc(resumeAbilityDto.getDesc());

                resumeAbility.setResume(resume);
                resume.addResumeAbilityList(resumeAbility);

                resumeAbilityRepository.save(resumeAbility);
                log.info("resumeAbility : " + resumeAbility);
            }
        }

        log.info("3");
        //ResumeAcademy
        //기존에 있던 것 지우고
        List<ResumeAcademy> resumeAcademies = resumeAcademyRepository.findByResume(resume);
        if(!resumeAcademies.isEmpty()) {
            for(ResumeAcademy resumeAcademy : resumeAcademies) {
                resumeAcademyRepository.delete(resumeAcademy);
            }
        }

        if(!resumeForm.getResumeAcademyDtos().isEmpty()) {
            for (ResumeAcademyDto resumeAcademyDto : resumeForm.getResumeAcademyDtos()) {
                ResumeAcademy resumeAcademy = new ResumeAcademy();

                if(!resumeAcademyDto.getSchoolType().isEmpty())
                    resumeAcademy.setSchoolType(resumeAcademyDto.getSchoolType());

                if(!resumeAcademyDto.getSchoolName().isEmpty())
                    resumeAcademy.setSchoolName(resumeAcademyDto.getSchoolName());

                if(!resumeAcademyDto.getMajorOrDesc().isEmpty())
                    resumeAcademy.setMajorOrDesc(resumeAcademyDto.getMajorOrDesc());

                resumeAcademy.setResume(resume);
                resume.addResumeAcademyList(resumeAcademy);

                resumeAcademyRepository.save(resumeAcademy);
                log.info("resumeAcademy: " + resumeAcademy);
            }
        }

        //Resume Additional Contact
        //기존에 있던 것 지우고
        List<ResumeAdditionalContact> resumeAdditionalContacts = resumeAdditionalContactRepository.findByResume(resume);
        if(!resumeAdditionalContacts.isEmpty()) {
            for(ResumeAdditionalContact resumeAdditionalContact : resumeAdditionalContacts) {
                resumeAdditionalContactRepository.delete(resumeAdditionalContact);
            }
        }

        if(!resumeForm.getResumeAdditionalContactDtos().isEmpty()) {
            for (ResumeAdditionalContactDto resumeAdditionalContactDto : resumeForm.getResumeAdditionalContactDtos()) {
                ResumeAdditionalContact resumeAdditionalContact = new ResumeAdditionalContact();

                ContactType contactType = contactTypeRepository.getById(resumeAdditionalContactDto.getContactTypeId());
                resumeAdditionalContact.setContactType(contactType);

                if(!resumeAdditionalContactDto.getContact().isEmpty())
                    resumeAdditionalContact.setContact(resumeAdditionalContactDto.getContact());

                resumeAdditionalContact.setResume(resume);
                resume.addResumeAdditionalContactList(resumeAdditionalContact);

                resumeAdditionalContactRepository.save(resumeAdditionalContact);
                log.info("resumeAdditionalContact : " + resumeAdditionalContact);
            }
        }

        //Resume Certificate
        //기존에 있던 것 지우고
        List<ResumeCertificate> resumeCertificates = resumeCertificateRepository.findByResume(resume);
        if(!resumeCertificates.isEmpty()) {
            for(ResumeCertificate resumeCertificate : resumeCertificates) {
                resumeCertificateRepository.delete(resumeCertificate);
            }
        }

        if(!resumeForm.getResumeCertificateDtos().isEmpty()) {
            for (ResumeCertificateDto resumeCertificateDto : resumeForm.getResumeCertificateDtos()) {
                ResumeCertificate resumeCertificate = new ResumeCertificate();

                if(!resumeCertificateDto.getCertificateName().isEmpty())
                    resumeCertificate.setCertificateName(resumeCertificateDto.getCertificateName());

                if(!resumeCertificateDto.getGrade().isEmpty())
                    resumeCertificate.setGrade(resumeCertificateDto.getCertificateName());

                resumeCertificate.setResume(resume);
                resume.addResumeCertificateList(resumeCertificate);

                resumeCertificateRepository.save(resumeCertificate);
                log.info("resumeCertificate : " + resumeCertificate);
            }
        }

        //Resume Hoped Field
        //기존에 있던 것 지우고
        List<ResumeHopedField> resumeHopedFields = resumeHopedFieldRepository.findByResume(resume);
        if(!resumeHopedFields.isEmpty()) {
            for(ResumeHopedField resumeHopedField : resumeHopedFields) {
                resumeHopedFieldRepository.delete(resumeHopedField);
            }
        }

        if(!resumeForm.getResumeHopedFieldDtos().isEmpty()) {
            for (ResumeHopedFieldDto resumeHopedFieldDto : resumeForm.getResumeHopedFieldDtos()) {
                ResumeHopedField resumeHopedField = new ResumeHopedField();

                ProjectField firstField = projectFieldRepository.getById(resumeHopedFieldDto.getFirstFieldId());
                ProjectField secondField = projectFieldRepository.getById(resumeHopedFieldDto.getSecondFieldId());
                resumeHopedField.setFirstField(firstField);
                resumeHopedField.setSecondField(secondField);

                resumeHopedField.setResume(resume);
                resume.addResumeHopedFieldList(resumeHopedField);

                resumeHopedFieldRepository.save(resumeHopedField);
                log.info("resumeHopedField : " + resumeHopedField);
            }
        }




        return resumeForm;
    }

    @Transactional
    public ResumeDto deleteResume(ResumeDto resumeForm) {
        log.info("In delete resume");
        if(!resumeRepository.existsById(resumeForm.getId())) {
            throw new ResumeNotFountException("해당하는 이력서를 찾을 수 없습니다.");
        }

        Resume resume = resumeRepository.getById(resumeForm.getId());

        //ResumeAbility
        //기존에 있던 것 지우고
        List<ResumeAbility> resumeAbilities = resumeAbilityRepository.findByResume(resume);
        if(!resumeAbilities.isEmpty()) {
            for(ResumeAbility resumeAbility : resumeAbilities) {
                resumeAbilityRepository.delete(resumeAbility);
            }
        }

        //ResumeAcademy
        //기존에 있던 것 지우고
        List<ResumeAcademy> resumeAcademies = resumeAcademyRepository.findByResume(resume);
        if(!resumeAcademies.isEmpty()) {
            for(ResumeAcademy resumeAcademy : resumeAcademies) {
                resumeAcademyRepository.delete(resumeAcademy);
            }
        }

        //Resume Additional Contact
        //기존에 있던 것 지우고
        List<ResumeAdditionalContact> resumeAdditionalContacts = resumeAdditionalContactRepository.findByResume(resume);
        if(!resumeAdditionalContacts.isEmpty()) {
            for(ResumeAdditionalContact resumeAdditionalContact : resumeAdditionalContacts) {
                resumeAdditionalContactRepository.delete(resumeAdditionalContact);
            }
        }

        //Resume Certificate
        //기존에 있던 것 지우고
        List<ResumeCertificate> resumeCertificates = resumeCertificateRepository.findByResume(resume);
        if(!resumeCertificates.isEmpty()) {
            for(ResumeCertificate resumeCertificate : resumeCertificates) {
                resumeCertificateRepository.delete(resumeCertificate);
            }
        }
        //Resume Hoped Field
        //기존에 있던 것 지우고
        List<ResumeHopedField> resumeHopedFields = resumeHopedFieldRepository.findByResume(resume);
        if(!resumeHopedFields.isEmpty()) {
            for(ResumeHopedField resumeHopedField : resumeHopedFields) {
                resumeHopedFieldRepository.delete(resumeHopedField);
            }
        }

        Account createdBy = accountRepository.findByEmail(resume.getCreatedBy().getEmail());
        createdBy.decrementResumeCnt();
        accountRepository.save(createdBy);

        resumeRepository.delete(resume);
        return resumeForm;
    }
}
