package com.example.demo.module.file.controller;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.domain.file.FileDto;
import com.example.demo.module.file.domain.file.FileTrDto;
import com.example.demo.module.file.domain.sentence.TranslatedSentenceForm;
import com.example.demo.module.file.service.CustomFileService;
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
public class FileController {
    private final CustomFileService customFileService;

    @PostMapping("file/upload/tr")
    public String saveTrFile(//@RequestBody FileTestDto data
                           @RequestParam("files") List<MultipartFile> files)
            throws IOException, Exception {
        log.info("file upload api");
        log.info("data : " + files);

        customFileService.uploadTrFiles(files, "test");

        return "uploaded";
    }


    @PostMapping("file/upload/project")
    public String saveFile(//@RequestBody FileTestDto data
                           @RequestParam("files") List<MultipartFile> files,
                           @RequestParam("project") String projectId) throws IOException, Exception {
        log.info("file upload api");
        log.info("data : " + files);
        log.info("data : " + projectId);

        customFileService.uploadFiles(files, Long.parseLong(projectId), "project");

        return "uploaded";
    }

    @PostMapping("file/upload/app")
    public String saveJobFile(//@RequestBody FileTestDto data
                           @RequestParam("files") List<MultipartFile> files,
                           @RequestParam("applicationId") String applicationId) throws IOException, Exception {
        System.out.println("file upload api");
        System.out.println("data : " + files);
        System.out.println("data : " + applicationId);

        customFileService.uploadAppFiles(files, Long.parseLong(applicationId));

        return "uploaded";
    }

    //파일 다운로드 개선 필요
    @GetMapping("/file/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String fileId, HttpServletRequest request)
    throws Exception {
        log.info("file download api");
        log.info("fileId : " + fileId);
        CustomFile customFile = customFileService.loadFile(Long.parseLong(fileId));

        String downloadPath = customFile.getFilePath();
        String fileName = customFile.getOriginalName();
        //String ext = fileName.substring(fileName.lastIndexOf(".") + 1); //확장자

        File file = new File(downloadPath, customFile.getSaveName());
        Resource resource = new UrlResource(file.toURI());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + fileName + "\"")
                        .header("pragma", fileName)
                        .body(resource);
    }


    //파일 다운로드 개선 필요
    @PostMapping("/file/test")
    public List<FileDto> downloadFile() {
        log.info("get test files api");
        return customFileService.loadTestFile();
    }

    @PostMapping("/file/app")
    public List<FileDto> fetchJobFiles(@RequestBody ApplicationDto data) {
        System.out.println("get job files api");
        return customFileService.loadAppFiles(data);
    }

    @GetMapping("/file/one/{id}")
    public List<TranslatedSentenceForm> downloadTestFile(@PathVariable("id") Long id) {
        log.info("/file/one/test");
        System.out.println("data : " + id);
        List<TranslatedSentenceForm> result = customFileService.getFileSentences(id);
        System.out.println(result);
        return result;
    }

    @PostMapping("/file/detail")
    public FileTrDto getDetail(@RequestBody FileDto data) {
        System.out.println("detail");
        return customFileService.getDetail(data);
    }
}
