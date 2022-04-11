package com.example.demo.module.file.domain.file;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.module.file.domain.file.QFileDto is a Querydsl Projection type for FileDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFileDto extends ConstructorExpression<FileDto> {

    private static final long serialVersionUID = -411314127L;

    public QFileDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<String> originalName, com.querydsl.core.types.Expression<String> saveName, com.querydsl.core.types.Expression<String> filePath) {
        super(FileDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class, String.class, String.class, String.class}, id, createdDate, originalName, saveName, filePath);
    }

}

