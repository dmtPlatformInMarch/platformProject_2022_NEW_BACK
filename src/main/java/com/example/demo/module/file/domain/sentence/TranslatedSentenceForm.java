package com.example.demo.module.file.domain.sentence;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TranslatedSentenceForm {
    String originText;
    String translatedText;
    String comment;
    int columnIndex;
}
