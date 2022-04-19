package com.example.demo.module.job.domain.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJob is a Querydsl query type for Job
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJob extends EntityPathBase<Job> {

    private static final long serialVersionUID = -1631013532L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJob job = new QJob("job");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final QApplication application;

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final com.example.demo.module.file.domain.file.QCustomFile customFile;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<JobStatus> jobStatus = createEnum("jobStatus", JobStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> progress = createNumber("progress", Long.class);

    public final com.example.demo.module.project.domain.entity.QProject project;

    public QJob(String variable) {
        this(Job.class, forVariable(variable), INITS);
    }

    public QJob(Path<? extends Job> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJob(PathMetadata metadata, PathInits inits) {
        this(Job.class, metadata, inits);
    }

    public QJob(Class<? extends Job> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.application = inits.isInitialized("application") ? new QApplication(forProperty("application"), inits.get("application")) : null;
        this.customFile = inits.isInitialized("customFile") ? new com.example.demo.module.file.domain.file.QCustomFile(forProperty("customFile")) : null;
        this.project = inits.isInitialized("project") ? new com.example.demo.module.project.domain.entity.QProject(forProperty("project"), inits.get("project")) : null;
    }

}

