package com.example.demo.module.project.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectField is a Querydsl query type for ProjectField
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectField extends EntityPathBase<ProjectField> {

    private static final long serialVersionUID = 1455558143L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectField projectField = new QProjectField("projectField");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final StringPath explanation = createString("explanation");

    public final StringPath fieldName = createString("fieldName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QProjectField parentProjectField;

    public QProjectField(String variable) {
        this(ProjectField.class, forVariable(variable), INITS);
    }

    public QProjectField(Path<? extends ProjectField> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectField(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectField(PathMetadata metadata, PathInits inits) {
        this(ProjectField.class, metadata, inits);
    }

    public QProjectField(Class<? extends ProjectField> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentProjectField = inits.isInitialized("parentProjectField") ? new QProjectField(forProperty("parentProjectField"), inits.get("parentProjectField")) : null;
    }

}

