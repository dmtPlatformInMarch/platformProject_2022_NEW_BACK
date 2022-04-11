package com.example.demo.module.file.repository;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.domain.file.FileDto;
import com.example.demo.module.file.domain.file.QCustomFile;
import com.example.demo.module.file.domain.file.QFileDto;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Slf4j
public class CustomFileRepositoryExtensionImpl extends QuerydslRepositorySupport implements CustomFileRepositoryExtension {
    public CustomFileRepositoryExtensionImpl() {
        super(CustomFile.class);
    }

    @Override
    public List<FileDto> findTestFiles() {
        QCustomFile customFile = QCustomFile.customFile;
        JPQLQuery<FileDto> jpqlQuery = from(customFile)
                .where(customFile.objectType.eq("test"))
                .select(new QFileDto(
                        customFile.id, customFile.createdDate,
                        customFile.originalName, customFile.saveName,
                        customFile.filePath
                ));
        return jpqlQuery.fetch();
    }

    @Override
    public List<FileDto> findAppFiles(Long id) {
        QCustomFile customFile = QCustomFile.customFile;
        JPQLQuery<FileDto> jpqlQuery = from(customFile)
                .where(customFile.objectType.eq("application")
                    .and(customFile.objectCode.eq(id)))
                .select(new QFileDto(
                        customFile.id, customFile.createdDate,
                        customFile.originalName, customFile.saveName,
                        customFile.filePath
                ));
        return jpqlQuery.fetch();
    }

}
