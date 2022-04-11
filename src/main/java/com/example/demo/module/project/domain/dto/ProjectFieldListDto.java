package com.example.demo.module.project.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProjectFieldListDto {
    private Long id;
    private String fieldName;
    private Long parentId;
    private int depth;

    @QueryProjection
    public ProjectFieldListDto(Long id, String fieldName, Long parentId, int depth) {
        this.id = id;
        this.fieldName = fieldName;
        this.parentId = parentId;
        this.depth = depth;
    }
}
