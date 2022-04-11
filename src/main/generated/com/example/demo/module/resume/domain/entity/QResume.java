package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -1384089433L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResume resume = new QResume("resume");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath content = createString("content");

    public final com.example.demo.module.account.domain.entity.QAccount createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath hopedWorkingPeriod = createString("hopedWorkingPeriod");

    public final StringPath hopedWorkingPlace = createString("hopedWorkingPlace");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOpened = createBoolean("isOpened");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final ListPath<ResumeAbility, QResumeAbility> resumeAbilities = this.<ResumeAbility, QResumeAbility>createList("resumeAbilities", ResumeAbility.class, QResumeAbility.class, PathInits.DIRECT2);

    public final ListPath<ResumeAcademy, QResumeAcademy> resumeAcademies = this.<ResumeAcademy, QResumeAcademy>createList("resumeAcademies", ResumeAcademy.class, QResumeAcademy.class, PathInits.DIRECT2);

    public final ListPath<ResumeAdditionalContact, QResumeAdditionalContact> resumeAdditionalContacts = this.<ResumeAdditionalContact, QResumeAdditionalContact>createList("resumeAdditionalContacts", ResumeAdditionalContact.class, QResumeAdditionalContact.class, PathInits.DIRECT2);

    public final ListPath<ResumeCertificate, QResumeCertificate> resumeCertificates = this.<ResumeCertificate, QResumeCertificate>createList("resumeCertificates", ResumeCertificate.class, QResumeCertificate.class, PathInits.DIRECT2);

    public final NumberPath<Integer> resumeHopedFieldCnt = createNumber("resumeHopedFieldCnt", Integer.class);

    public final ListPath<ResumeHopedField, QResumeHopedField> resumeHopedFields = this.<ResumeHopedField, QResumeHopedField>createList("resumeHopedFields", ResumeHopedField.class, QResumeHopedField.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QResume(String variable) {
        this(Resume.class, forVariable(variable), INITS);
    }

    public QResume(Path<? extends Resume> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResume(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResume(PathMetadata metadata, PathInits inits) {
        this(Resume.class, metadata, inits);
    }

    public QResume(Class<? extends Resume> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.example.demo.module.account.domain.entity.QAccount(forProperty("createdBy"), inits.get("createdBy")) : null;
    }

}

