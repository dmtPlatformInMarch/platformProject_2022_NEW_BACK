package com.example.demo.module.file.domain.file;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomFile is a Querydsl query type for CustomFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomFile extends EntityPathBase<CustomFile> {

    private static final long serialVersionUID = 1423357023L;

    public static final QCustomFile customFile = new QCustomFile("customFile");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> objectCode = createNumber("objectCode", Long.class);

    public final StringPath objectType = createString("objectType");

    public final StringPath originalName = createString("originalName");

    public final StringPath saveName = createString("saveName");

    public final NumberPath<Long> size = createNumber("size", Long.class);

    public QCustomFile(String variable) {
        super(CustomFile.class, forVariable(variable));
    }

    public QCustomFile(Path<? extends CustomFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomFile(PathMetadata metadata) {
        super(CustomFile.class, metadata);
    }

}

