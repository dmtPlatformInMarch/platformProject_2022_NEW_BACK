package com.example.demo.module.file.service;

import com.example.demo.module.file.domain.file.CustomFile;
import com.example.demo.module.file.domain.file.FileDto;
import com.example.demo.module.file.domain.file.FileTrDto;
import com.example.demo.module.file.domain.sentence.TranslatedSentenceForm;
import com.example.demo.module.file.repository.CustomFileRepository;
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
public class CustomFileService {
    private final CustomFileRepository customFileRepository;
    private final FileUtils fileUtils;


    //uploadTrFiles
    @Transactional
    public void uploadTrFiles(List<MultipartFile> files, String objectType) throws Exception {
        List<CustomFile> fileList = fileUtils.uploadTrFile(files, objectType);
        log.info("fileList : " + fileList);
        for(CustomFile f : fileList) {
            if(f == null)
            {
                log.info("file is empty");
                continue;
            }
            customFileRepository.save(f);
        }
    }

    @Transactional
    public void uploadFiles(List<MultipartFile> files, Long id, String objectType) throws Exception {
        List<CustomFile> fileList = fileUtils.uploadFile(files, id, objectType);
        log.info("fileList : " + fileList);
        for(CustomFile f : fileList) {
            if(f == null)
            {
                log.info("file is empty");
                continue;
            }
            customFileRepository.save(f);
        }
    }

    private final ApplicationRepository applicationRepository;
    private final JobService jobService;

    @Transactional
    public void uploadAppFiles(List<MultipartFile> files, Long id ) throws Exception {
        List<CustomFile> fileList = fileUtils.uploadFile(files, id, "application");
        Application application = applicationRepository.getById(id);

        log.info("fileList : " + fileList);
        for(CustomFile f : fileList) {
            if(f == null)
            {
                log.info("file is empty");
                continue;
            }
            CustomFile savedFile = customFileRepository.save(f);
            jobService.createNewJob(application, savedFile);
        }
    }


    @Transactional
    public CustomFile loadFile(Long id) throws Exception{
        if(!customFileRepository.existsById(id))
            throw new FileNotFoundException("해당하는 파일이 존재하지 않습니다");

        return customFileRepository.getById(id);
    }

    @Transactional
    public List<CustomFile> loadFileWithObject(Long objectCode, String objectType) {
        if(!customFileRepository.existsByObjectCodeAndObjectType(objectCode, objectType)) return null;

        List<CustomFile> results = customFileRepository.findByObjectCodeAndObjectType(objectCode, objectType);
        return results;
    }


    @Transactional
    public List<FileDto> loadTestFile() {
        List<FileDto> results = customFileRepository.findTestFiles();
        return results;
    }

    @Transactional
    public List<FileDto> loadAppFiles(ApplicationDto data) {
        System.out.println("load app files");
        System.out.println("data: " + data);
        List<FileDto> results = customFileRepository.findAppFiles(data.getId());
        return results;
    }


    // 번역문

    @Transactional
    public List<TranslatedSentenceForm> getFileSentences(Long fileId) {
        CustomFile file = customFileRepository.findById(fileId).get();

        String uploadPath = Paths.get(file.getFilePath()).toString();

        String fileName = file.getOriginalName();
        File downloadFile = new File(uploadPath, file.getSaveName());

        List<TranslatedSentenceForm> texts = new ArrayList<>();

        try {
            FileInputStream fileStream = new FileInputStream(downloadFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fileStream);

            int rowindex=1;
            int columnindex=0;
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=1;rowindex<rows;rowindex++){
                //행을읽는다
                XSSFRow row=sheet.getRow(rowindex);
                TranslatedSentenceForm tf = new TranslatedSentenceForm();
                if(row !=null){
                    //셀의 수
                    int cells=row.getPhysicalNumberOfCells();
                    for(columnindex=0; columnindex<=cells; columnindex++){
                        //셀값을 읽는다
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        //셀이 빈값일경우를 위한 널체크
                        if(cell==null){
                            continue;
                        }else{
                            //타입별로 내용 읽기
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    value=cell.getNumericCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }
                        System.out.println(rowindex+"번 행 : "+columnindex+"번 열 값은: "+value);

                        if(columnindex == 0) {
                            if(value==null) value="";
                            tf.setOriginText(value);
                        }
                        else {
                            if(value==null) value="";
                            tf.setTranslatedText(value);
                        }
                    }

                }

                texts.add(tf);

            }

        }catch(Exception e) {
            e.printStackTrace();
        }


        return texts;
    }

    private final ProjectRepository projectRepository;
    private final ProjectFieldRepository projectFieldRepository;

    @Transactional
    public FileTrDto getDetail(FileDto data) {
        System.out.println("data : " + data); //id (file id)
        CustomFile file = customFileRepository.findById(data.getId()).get();

        FileTrDto fileTrDto = new FileTrDto();
        fileTrDto.setOriginalFileName(file.getOriginalName());

        if(file.getObjectType().equals("application")) {
            System.out.println("application");
            Application app = applicationRepository.findById(file.getObjectCode()).get();
            Project project = projectRepository.findById(app.getProject().getId()).get();

            ProjectField firstField = projectFieldRepository.getById(project.getFirstField().getId());
            if(firstField.getId() == 1) { //번역일 경우
                ProjectField secondField = projectFieldRepository.getById(project.getSecondField().getId());
                String tr = secondField.getFieldName();
                String tr1 = tr.substring(0, 1);
                String tr2 = tr.substring(2);
                System.out.println("tr1 : " + tr1);
                System.out.println("tr2 : " + tr2);

                fileTrDto.setTr1(tr1);
                fileTrDto.setTr2(tr2);
            }
        }

        return fileTrDto;
    }
}
