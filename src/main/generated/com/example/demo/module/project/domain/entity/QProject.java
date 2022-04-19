package com.example.demo.module.project.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = 1905475515L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProject project = new QProject("project");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final ListPath<com.example.demo.module.job.domain.domain.Application, com.example.demo.module.job.domain.domain.QApplication> applicationList = this.<com.example.demo.module.job.domain.domain.Application, com.example.demo.module.job.domain.domain.QApplication>createList("applicationList", com.example.demo.module.job.domain.domain.Application.class, com.example.demo.module.job.domain.domain.QApplication.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final com.example.demo.module.account.domain.entity.QAccount createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.util.Date> deadline = createDateTime("deadline", java.util.Date.class);

    public final NumberPath<Integer> favoriteCnt = createNumber("favoriteCnt", Integer.class);

    public final QProjectField firstField;

    public final NumberPath<Integer> fixedPayment = createNumber("fixedPayment", Integer.class);

    public final NumberPath<Integer> fromPayment = createNumber("fromPayment", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOpened = createBoolean("isOpened");

    public final NumberPath<Integer> jobCnt = createNumber("jobCnt", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final BooleanPath paymentType = createBoolean("paymentType");

    public final QProjectSeries projectSeries;

    public final QProjectField secondField;

    public final QProjectField thirdField;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> toPayment = createNumber("toPayment", Integer.class);

    public final NumberPath<Integer> viewCnt = createNumber("viewCnt", Integer.class);

    public QProject(String variable) {
        this(Project.class, forVariable(variable), INITS);
    }

    public QProject(Path<? extends Project> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProject(PathMetadata metadata, PathInits inits) {
        this(Project.class, metadata, inits);
    }

    public QProject(Class<? extends Project> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.example.demo.module.account.domain.entity.QAccount(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.firstField = inits.isInitialized("firstField") ? new QProjectField(forProperty("firstField"), inits.get("firstField")) : null;
        this.projectSeries = inits.isInitialized("projectSeries") ? new QProjectSeries(forProperty("projectSeries"), inits.get("projectSeries")) : null;
        this.secondField = inits.isInitialized("secondField") ? new QProjectField(forProperty("secondField"), inits.get("secondField")) : null;
        this.thirdField = inits.isInitialized("thirdField") ? new QProjectField(forProperty("thirdField"), inits.get("thirdField")) : null;
    }

}

