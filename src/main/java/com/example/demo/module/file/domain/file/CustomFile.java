package com.example.demo.module.file.domain.file;

import com.example.demo.module.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOM_FILE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CustomFile extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOM_FILE_ID")
    private Long id;

    private String originalName;

    private String saveName;

    private long size;

    private String objectType;

    private Long objectCode;

    private boolean isDeleted = false;

    private String filePath;
}
