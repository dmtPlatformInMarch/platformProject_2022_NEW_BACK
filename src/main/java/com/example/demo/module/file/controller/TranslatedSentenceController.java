package com.example.demo.module.file.controller;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.domain.file.FileDto;
import com.example.demo.module.file.domain.file.FileTrDto;
import com.example.demo.module.file.domain.sentence.TranslatedSentence;
import com.example.demo.module.file.domain.sentence.TranslatedSentenceForm;
import com.example.demo.module.file.service.CustomFileService;
import com.example.demo.module.file.service.TranslatedSentenceService;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TranslatedSentenceController {
    private final TranslatedSentenceService translatedSentenceService;
    //파일 다운로드 개선 필요
    @PostMapping("/sentence/save")
    public List<TranslatedSentence> saveSentences(@RequestBody List<TranslatedSentenceForm> data) {
        System.out.println("save sentences");
        System.out.println("data : " + data);

        List<TranslatedSentence> result = translatedSentenceService.saveSentences(data);
        for(TranslatedSentence sentence : result) {
            System.out.println(sentence);
        }

        return result;
    }
}
