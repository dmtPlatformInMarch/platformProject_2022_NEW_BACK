package com.example.demo.module.file.repository;
import com.example.demo.module.file.domain.sentence.TranslatedSentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslatedSentenceRepository extends JpaRepository<TranslatedSentence, Long> {

}
