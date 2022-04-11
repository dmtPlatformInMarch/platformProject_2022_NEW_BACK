package com.example.demo.module.file.domain.file;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
public class FileDto {
    Long id;
    LocalDateTime createdDate;
    String originalName;
    String saveName;
    String filePath;

    @QueryProjection
    public FileDto(Long id,
                   LocalDateTime createdDate,
                   String originalName,
                   String saveName,
                   String filePath) {
        this.id = id;
        this.createdDate = createdDate;
        this.originalName = originalName;
        this.saveName = saveName;
        this.filePath = filePath;
    }
}
