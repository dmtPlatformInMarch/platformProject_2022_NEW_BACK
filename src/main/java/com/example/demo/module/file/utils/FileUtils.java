package com.example.demo.module.file.utils;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.job.domain.domain.Application;
import com.example.demo.module.job.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileUtils {
    private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

    //원격 서버로 바꾸기
    //private final String uploadPath = Paths.get("/opt/", "platformServerFile", today).toString();
    private final String path1 = "/opt/";
    private final String path2 = "platformServerFile";

    //    private final String uploadPath = Paths.get("C:/", "testFiles", today).toString();
    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private final ApplicationRepository applicationRepository;

    public List<CustomFile> uploadFile (List<MultipartFile> files, Long objectCode, String objectType) throws Exception {
        List<CustomFile> attachList = new ArrayList<>();
        String path = null;

        if(objectType.equals("project")) {
            path = Paths.get(path1, path2, objectCode.toString()).toString();
        }

        else if(objectType.equals("application")) {
            Application app = applicationRepository.findById(objectCode).get();
            String path3 = app.getProject().getId().toString();
            path = Paths.get(path1, path2, path3, objectCode.toString()).toString();
        }


        File dir = new File(path);
        if(dir.exists() == false) {
            dir.mkdirs();
        }

        if(files.size()<1) {
            log.info("empty file list");
            return null;
        }

        log.info("non-empty file list");
        for(MultipartFile f : files) {
            if(f.isEmpty() || f == null)
            {
                log.info("file is empty");
                continue;
            }

            log.info("file " + f.getOriginalFilename() + " is being saved");
            if(f.getOriginalFilename().isEmpty()) {
                log.info("filename is empty");
            }
            else {
                log.info("filename is not empty");

                try {
                    final String extension = FilenameUtils.getExtension(f.getOriginalFilename());
                    final String saveName = getRandomString() + "." + extension;
                    File target = new File(path, saveName);
//                    Runtime.getRuntime().exec("chmod 777 " + uploadPath+saveName);
                    f.transferTo(target);

                    CustomFile attach = new CustomFile();
                    attach.setObjectType(objectType);
                    attach.setObjectCode(objectCode);
                    attach.setOriginalName(f.getOriginalFilename());
                    attach.setSaveName(saveName);
                    attach.setSize(f.getSize());
                    attach.setFilePath(path);
                    attachList.add(attach);

                } catch (IOException e) {
                    throw new IOException("failed to save file");
                } catch (Exception e) {
                    throw new Exception("failed to save file");
                }
            }
        }

        log.info("CustomFilesUtil list is " + attachList.size());
        return attachList;
    }


    /*

    public CustomFile uploadFile(MultipartFile file, String objectCode, String objectField) throws Exception {

        List<CustomFile> attachList = new ArrayList<>();
        CustomFile attach = null;

        File dir = new File(uploadPath);
        if(dir.exists() == false) {
            dir.mkdirs();
        }

        log.info("file " + file.getOriginalFilename() + " is being saved");
        if(file.getOriginalFilename().isEmpty()) {
            log.info("filename is empty");
        }
        else {
            log.info("filename is not empty");

            try {
                final String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                final String saveName = getRandomString() + "." + extension;
                File target = new File(uploadPath, saveName);
                file.transferTo(target); //파일 저장
                log.info("file saved");

                attach = new CustomFile();
                attach.setObjectCode(objectCode);
                attach.setObjectField(objectField);
                attach.setOriginalName(file.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(file.getSize());
                attach.setFilePath(uploadPath);

            } catch (IOException e) {
                throw new IOException("failed to save file");
            } catch (Exception e) {
                throw new Exception("failed to save file");
            }
        }

        return attach;
    }
     */


    public void downloadFile(CustomFile file, HttpServletResponse rs) {
       // if(fileCode == null) throw new IllegalArgumentException("File is empty");

       // CustomFile file = customFileService.getFile(fileCode);
        if(file == null || file.isDeleted() == true) {
            throw new IllegalArgumentException("File is empty");
        }
        String uploadDate = null;
        if (file.getCreatedDate()!=null) {
            log.info("createdDate exits");
            uploadDate = file.getCreatedDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
        }else {
            log.info("modifiedDate exits");
            uploadDate = file.getLastModifiedDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
        }
//        String uploadPath = Paths.get("C:/", "testFiles", uploadDate).toString();
        String downloadPath = file.getFilePath();
        //String uploadPath = Paths.get("/opt/", "platformServerFile", uploadDate).toString();
        String uploadPath = Paths.get(downloadPath).toString();

        String fileName = file.getOriginalName();

        File downloadFile = new File(uploadPath, file.getSaveName());
        try {
            byte[] data = org.apache.commons.io.FileUtils.readFileToByteArray(downloadFile);
            rs.setContentType("application/octet-stream");
            rs.setContentLength(data.length);
            rs.setHeader("Content-Transfer-Encoding", "binary");
            rs.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");

            rs.getOutputStream().write(data);
            rs.getOutputStream().flush();
            rs.getOutputStream().close();
        } catch(IOException e) {
            log.info("download failed");
        }
    }



    //uploadTrFile
    public List<CustomFile> uploadTrFile (List<MultipartFile> files, String objectType) throws Exception {
        List<CustomFile> attachList = new ArrayList<>();
        String path = null;

        if(objectType.equals("test")) {
            path = Paths.get(path1, path2, "test").toString();
        }

        File dir = new File(path);
        if(dir.exists() == false) {
            dir.mkdirs();
        }

        if(files.size()<1) {
            log.info("empty file list");
            return null;
        }

        log.info("non-empty file list");
        for(MultipartFile f : files) {
            if(f.isEmpty() || f == null)
            {
                log.info("file is empty");
                continue;
            }

            log.info("file " + f.getOriginalFilename() + " is being saved");
            if(f.getOriginalFilename().isEmpty()) {
                log.info("filename is empty");
            }
            else {
                log.info("filename is not empty");

                try {
                    final String extension = FilenameUtils.getExtension(f.getOriginalFilename());
                    final String saveName = getRandomString() + "." + extension;
                    File target = new File(path, saveName);
//                    Runtime.getRuntime().exec("chmod 777 " + uploadPath+saveName);
                    f.transferTo(target);

                    CustomFile attach = new CustomFile();
                    attach.setObjectType(objectType);
                    //attach.setObjectCode(objectCode);
                    attach.setOriginalName(f.getOriginalFilename());
                    attach.setSaveName(saveName);
                    attach.setSize(f.getSize());
                    attach.setFilePath(path);
                    attachList.add(attach);

                } catch (IOException e) {
                    throw new IOException("failed to save file");
                } catch (Exception e) {
                    throw new Exception("failed to save file");
                }
            }
        }

        log.info("CustomFilesUtil list is " + attachList.size());
        return attachList;
    }
}
