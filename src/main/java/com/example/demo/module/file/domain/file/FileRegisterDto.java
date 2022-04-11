package com.example.demo.module.file.domain.file;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@ToString
@Builder
public class FileRegisterDto {
    Long id;
    MultipartFile file;
    String fileName;
    int fileIdx;

    int Idx;
}
