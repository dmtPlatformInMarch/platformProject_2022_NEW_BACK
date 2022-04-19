package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QContactType is a Querydsl query type for ContactType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QContactType extends EntityPathBase<ContactType> {

    private static final long serialVersionUID = -1315265728L;

    public static final QContactType contactType1 = new QContactType("contactType1");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath contactType = createString("contactType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public QContactType(String variable) {
        super(ContactType.class, forVariable(variable));
    }

    public QContactType(Path<? extends ContactType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContactType(PathMetadata metadata) {
        super(ContactType.class, metadata);
    }

}

