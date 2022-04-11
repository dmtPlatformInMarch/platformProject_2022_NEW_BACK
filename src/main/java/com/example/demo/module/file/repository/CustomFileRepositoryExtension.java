package com.example.demo.module.file.repository;

import com.example.demo.module.file.domain.file.FileDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CustomFileRepositoryExtension {
    List<FileDto> findTestFiles();
    List<FileDto> findAppFiles(Long id);
}
