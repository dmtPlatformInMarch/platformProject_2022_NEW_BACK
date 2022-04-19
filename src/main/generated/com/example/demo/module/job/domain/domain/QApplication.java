package com.example.demo.module.job.domain.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplication is a Querydsl query type for Application
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApplication extends EntityPathBase<Application> {

    private static final long serialVersionUID = -1410955273L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplication application = new QApplication("application");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath applicationContent = createString("applicationContent");

    public final EnumPath<ApplicationStatus> applicationStatus = createEnum("applicationStatus", ApplicationStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isWorkerApplied = createBoolean("isWorkerApplied");

    public final ListPath<Job, QJob> jobList = this.<Job, QJob>createList("jobList", Job.class, QJob.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final com.example.demo.module.account.domain.entity.QAccount manager;

    public final com.example.demo.module.project.domain.entity.QProject project;

    public final com.example.demo.module.resume.domain.entity.QResume resume;

    public final com.example.demo.module.account.domain.entity.QAccount worker;

    public QApplication(String variable) {
        this(Application.class, forVariable(variable), INITS);
    }

    public QApplication(Path<? extends Application> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplication(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplication(PathMetadata metadata, PathInits inits) {
        this(Application.class, metadata, inits);
    }

    public QApplication(Class<? extends Application> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.manager = inits.isInitialized("manager") ? new com.example.demo.module.account.domain.entity.QAccount(forProperty("manager"), inits.get("manager")) : null;
        this.project = inits.isInitialized("project") ? new com.example.demo.module.project.domain.entity.QProject(forProperty("project"), inits.get("project")) : null;
        this.resume = inits.isInitialized("resume") ? new com.example.demo.module.resume.domain.entity.QResume(forProperty("resume"), inits.get("resume")) : null;
        this.worker = inits.isInitialized("worker") ? new com.example.demo.module.account.domain.entity.QAccount(forProperty("worker"), inits.get("worker")) : null;
    }

}

