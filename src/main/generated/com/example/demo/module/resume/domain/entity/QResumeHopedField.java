package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeHopedField is a Querydsl query type for ResumeHopedField
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResumeHopedField extends EntityPathBase<ResumeHopedField> {

    private static final long serialVersionUID = 551049017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeHopedField resumeHopedField = new QResumeHopedField("resumeHopedField");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final com.example.demo.module.project.domain.entity.QProjectField firstField;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QResume resume;

    public final com.example.demo.module.project.domain.entity.QProjectField secondField;

    public QResumeHopedField(String variable) {
        this(ResumeHopedField.class, forVariable(variable), INITS);
    }

    public QResumeHopedField(Path<? extends ResumeHopedField> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeHopedField(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeHopedField(PathMetadata metadata, PathInits inits) {
        this(ResumeHopedField.class, metadata, inits);
    }

    public QResumeHopedField(Class<? extends ResumeHopedField> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.firstField = inits.isInitialized("firstField") ? new com.example.demo.module.project.domain.entity.QProjectField(forProperty("firstField"), inits.get("firstField")) : null;
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
        this.secondField = inits.isInitialized("secondField") ? new com.example.demo.module.project.domain.entity.QProjectField(forProperty("secondField"), inits.get("secondField")) : null;
    }

}

