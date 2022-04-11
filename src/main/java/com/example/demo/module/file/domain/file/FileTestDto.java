package com.example.demo.module.file.domain.file;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
public class FileTestDto {
    int fileIdx;
    int Idx;
    List<FileRegisterDto> files = new ArrayList<>();
}
