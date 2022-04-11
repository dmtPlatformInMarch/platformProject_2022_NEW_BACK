package com.example.demo.module.resume.service;

import com.example.demo.module.resume.domain.entity.ContactType;
import com.example.demo.module.resume.repository.ContactTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactTypeService {
    private final ContactTypeRepository contactTypeRepository;

    @Transactional
    public List<ContactType> getAllContactTypes() {
        log.info("contact service");
        return contactTypeRepository.findAll();
    }
}
