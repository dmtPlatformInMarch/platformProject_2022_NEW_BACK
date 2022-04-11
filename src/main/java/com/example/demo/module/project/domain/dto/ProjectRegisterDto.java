package com.example.demo.module.project.domain.dto;

import com.example.demo.module.file.domain.file.CustomFile;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class ProjectRegisterDto {
    private Long id;
    private String title;
    private String series;
    private String firstField;
    private String secondField;
    private String thirdField;
    private String content;
    private Date deadline;
    private boolean paymentType;
    private Integer fixedPayment;
    private Integer toPayment;
    private Integer fromPayment;
    private boolean isOpened;
    private String createdBy;
    private String seriesTitle;
    private Long firstFieldId;
    private Long secondFieldId;
    private Long thirdFieldId;
    private int favoriteCnt;
    private int jobCnt;
    private int viewCnt;
    private LocalDateTime createdDate;
    private int fileCnt;
    private List<CustomFile> files = new ArrayList<>();
    private boolean isApplied;
    private String userEmail;
}
