package com.example.demo.module.file.domain.sentence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslatedSentence is a Querydsl query type for TranslatedSentence
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslatedSentence extends EntityPathBase<TranslatedSentence> {

    private static final long serialVersionUID = -416761116L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranslatedSentence translatedSentence = new QTranslatedSentence("translatedSentence");

    public final NumberPath<Integer> columnIndex = createNumber("columnIndex", Integer.class);

    public final StringPath comment = createString("comment");

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final BooleanPath isSaved = createBoolean("isSaved");

    public final BooleanPath isUpdated = createBoolean("isUpdated");

    public final StringPath originText = createString("originText");

    public final com.example.demo.module.file.domain.file.QCustomFile subFile;

    public final StringPath subFileName = createString("subFileName");

    public final NumberPath<Long> translatedSentenceCode = createNumber("translatedSentenceCode", Long.class);

    public final StringPath translatedText = createString("translatedText");

    public QTranslatedSentence(String variable) {
        this(TranslatedSentence.class, forVariable(variable), INITS);
    }

    public QTranslatedSentence(Path<? extends TranslatedSentence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranslatedSentence(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranslatedSentence(PathMetadata metadata, PathInits inits) {
        this(TranslatedSentence.class, metadata, inits);
    }

    public QTranslatedSentence(Class<? extends TranslatedSentence> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subFile = inits.isInitialized("subFile") ? new com.example.demo.module.file.domain.file.QCustomFile(forProperty("subFile")) : null;
    }

}

