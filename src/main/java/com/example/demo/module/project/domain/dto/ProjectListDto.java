package com.example.demo.module.project.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
public class ProjectListDto {
    private Long id;

    private String title;
    private String firstFieldName;
    private String content;

    private LocalDateTime createdDate;
    private Date deadline;

    private boolean paymentType;
    private Integer fixedPayment;
    private Integer toPayment;
    private Integer fromPayment;

    private int favoriteCnt;
    private boolean isOpened;

    private String createdBy;

    @QueryProjection
    public ProjectListDto(Long id, String title, String content, String firstFieldName,
                          LocalDateTime createdDate, Date deadline, boolean paymentType,
                          Integer fixedPayment, Integer toPayment, Integer fromPayment,
                          int favoriteCnt, boolean isOpened, String createdBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.firstFieldName = firstFieldName;
        this.createdDate = createdDate;
        this.deadline = deadline;
        this.paymentType = paymentType;
        this.fixedPayment = fixedPayment;
        this.toPayment = toPayment;
        this.fromPayment = fromPayment;
        this.favoriteCnt = favoriteCnt;
        this.isOpened = isOpened;
        this.createdBy = createdBy;
    }
}
