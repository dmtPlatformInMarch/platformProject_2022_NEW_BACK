package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeAdditionalContact is a Querydsl query type for ResumeAdditionalContact
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResumeAdditionalContact extends EntityPathBase<ResumeAdditionalContact> {

    private static final long serialVersionUID = 1413669906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeAdditionalContact resumeAdditionalContact = new QResumeAdditionalContact("resumeAdditionalContact");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath contact = createString("contact");

    public final QContactType contactType;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QResume resume;

    public QResumeAdditionalContact(String variable) {
        this(ResumeAdditionalContact.class, forVariable(variable), INITS);
    }

    public QResumeAdditionalContact(Path<? extends ResumeAdditionalContact> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeAdditionalContact(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeAdditionalContact(PathMetadata metadata, PathInits inits) {
        this(ResumeAdditionalContact.class, metadata, inits);
    }

    public QResumeAdditionalContact(Class<? extends ResumeAdditionalContact> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contactType = inits.isInitialized("contactType") ? new QContactType(forProperty("contactType")) : null;
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

