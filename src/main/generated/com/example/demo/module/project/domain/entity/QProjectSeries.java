package com.example.demo.module.project.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectSeries is a Querydsl query type for ProjectSeries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectSeries extends EntityPathBase<ProjectSeries> {

    private static final long serialVersionUID = -1753468398L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectSeries projectSeries = new QProjectSeries("projectSeries");

    public final StringPath content = createString("content");

    public final com.example.demo.module.account.domain.entity.QAccount createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOpened = createBoolean("isOpened");

    public final ListPath<Project, QProject> projectList = this.<Project, QProject>createList("projectList", Project.class, QProject.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QProjectSeries(String variable) {
        this(ProjectSeries.class, forVariable(variable), INITS);
    }

    public QProjectSeries(Path<? extends ProjectSeries> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectSeries(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectSeries(PathMetadata metadata, PathInits inits) {
        this(ProjectSeries.class, metadata, inits);
    }

    public QProjectSeries(Class<? extends ProjectSeries> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.example.demo.module.account.domain.entity.QAccount(forProperty("createdBy"), inits.get("createdBy")) : null;
    }

}

