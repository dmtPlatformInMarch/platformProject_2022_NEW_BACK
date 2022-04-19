package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeCertificate is a Querydsl query type for ResumeCertificate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResumeCertificate extends EntityPathBase<ResumeCertificate> {

    private static final long serialVersionUID = 78664304L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeCertificate resumeCertificate = new QResumeCertificate("resumeCertificate");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath certificateName = createString("certificateName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath grade = createString("grade");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QResume resume;

    public QResumeCertificate(String variable) {
        this(ResumeCertificate.class, forVariable(variable), INITS);
    }

    public QResumeCertificate(Path<? extends ResumeCertificate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeCertificate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeCertificate(PathMetadata metadata, PathInits inits) {
        this(ResumeCertificate.class, metadata, inits);
    }

    public QResumeCertificate(Class<? extends ResumeCertificate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

