package com.example.demo.module.file.domain.sentence;

import com.example.demo.module.file.domain.file.CustomFile;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(of="workFieldCode", callSuper = false)
@AllArgsConstructor
@Builder
public class TranslatedSentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translatedSentenceCode;

    private String originText;
    private String translatedText;
    private String comment;

    private int columnIndex;

    @ManyToOne
    private CustomFile subFile;

   // @ManyToOne
   // private Member worker;

   // @ManyToOne
   // private Member checker;

    private String subFileName;

   // @ManyToOne
  //  private Member admin;

  //  private Long objectCode;
  //  private String objectType;

    private boolean isUpdated = false;
    private boolean isSaved = false;
    private boolean isConfirmed = false;
}
