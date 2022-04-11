package com.example.demo.module.file.domain.file;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class FileTrDto {
    public String originalFileName;
    public String tr1;
    public String tr2;
    public String ogTxt;
}
