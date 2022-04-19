package com.example.demo.module.file.service;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.domain.file.FileDto;
import com.example.demo.module.file.domain.file.FileTrDto;
import com.example.demo.module.file.domain.sentence.TranslatedSentence;
import com.example.demo.module.file.domain.sentence.TranslatedSentenceForm;
import com.example.demo.module.file.repository.CustomFileRepository;
import com.example.demo.module.file.repository.TranslatedSentenceRepository;
import com.example.demo.module.file.utils.FileUtils;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.domain.dto.ApplicationDto;
import com.example.demo.module.job.repository.ApplicationRepository;
import com.example.demo.module.job.service.JobService;
import com.example.demo.module.project.domain.entity.Project;
import com.example.demo.module.project.domain.entity.ProjectField;
import com.example.demo.module.project.repository.ProjectFieldRepository;
import com.example.demo.module.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TranslatedSentenceService {
    private final TranslatedSentenceRepository translatedSentenceRepository;
    private final CustomFileRepository customFileRepository;

    @Transactional
    public List<TranslatedSentence> saveSentences(List<TranslatedSentenceForm> data) {
        CustomFile customFile = customFileRepository.getById(Long.parseLong(data.get(0).getComment()));

        List<TranslatedSentence> trSentences = translatedSentenceRepository.findBySubFileOrderByColumnIndexAsc(customFile);

        if(trSentences.size() > 0) {
            for(TranslatedSentence translatedSentence : trSentences) {
                translatedSentenceRepository.delete(translatedSentence);
            }
        }

        List<TranslatedSentence> result = new ArrayList<>();

        int i = 0;
        for(TranslatedSentenceForm sentenceForm : data) {
            TranslatedSentence sentence = new TranslatedSentence();
            sentence.setColumnIndex(++i);
            sentence.setOriginText(sentenceForm.getOriginText());
            sentence.setTranslatedText(sentenceForm.getTranslatedText());
            sentence.setSubFile(customFile);

            result.add(translatedSentenceRepository.save(sentence));
        }

        return result;
    }
}
