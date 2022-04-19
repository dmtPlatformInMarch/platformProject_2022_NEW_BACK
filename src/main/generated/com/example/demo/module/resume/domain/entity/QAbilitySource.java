package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbilitySource is a Querydsl query type for AbilitySource
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAbilitySource extends EntityPathBase<AbilitySource> {

    private static final long serialVersionUID = 2013770795L;

    public static final QAbilitySource abilitySource = new QAbilitySource("abilitySource");

    public final com.example.demo.module.common.domain.QBaseEntity _super = new com.example.demo.module.common.domain.QBaseEntity(this);

    public final StringPath abilityType = createString("abilityType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public QAbilitySource(String variable) {
        super(AbilitySource.class, forVariable(variable));
    }

    public QAbilitySource(Path<? extends AbilitySource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbilitySource(PathMetadata metadata) {
        super(AbilitySource.class, metadata);
    }

}

