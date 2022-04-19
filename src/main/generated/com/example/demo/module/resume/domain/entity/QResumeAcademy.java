package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeAcademy is a Querydsl query type for ResumeAcademy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResumeAcademy extends EntityPathBase<ResumeAcademy> {

    private static final long serialVersionUID = -1873312699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeAcademy resumeAcademy = new QResumeAcademy("resumeAcademy");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath majorOrDesc = createString("majorOrDesc");

    public final QResume resume;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath schoolType = createString("schoolType");

    public QResumeAcademy(String variable) {
        this(ResumeAcademy.class, forVariable(variable), INITS);
    }

    public QResumeAcademy(Path<? extends ResumeAcademy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeAcademy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeAcademy(PathMetadata metadata, PathInits inits) {
        this(ResumeAcademy.class, metadata, inits);
    }

    public QResumeAcademy(Class<? extends ResumeAcademy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

