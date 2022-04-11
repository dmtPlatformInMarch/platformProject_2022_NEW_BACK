package com.example.demo.module.file.repository;
import com.example.demo.module.file.domain.file.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomFileRepository extends JpaRepository<CustomFile, Long>, CustomFileRepositoryExtension {
    List<CustomFile> findByObjectCode(Long objectCode);
    boolean existsByObjectCodeAndObjectType(Long objectCode, String objectType);
    List<CustomFile> findByObjectCodeAndObjectType(Long objectCode, String objectType);
    List<CustomFile> findByObjectType(String objectType);
}
