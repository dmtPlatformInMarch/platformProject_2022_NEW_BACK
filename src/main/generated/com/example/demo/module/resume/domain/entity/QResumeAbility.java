package com.example.demo.module.resume.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeAbility is a Querydsl query type for ResumeAbility
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResumeAbility extends EntityPathBase<ResumeAbility> {

    private static final long serialVersionUID = -1894311293L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeAbility resumeAbility = new QResumeAbility("resumeAbility");

    public final StringPath abilityDesc = createString("abilityDesc");

    public final QAbilitySource abilitySource;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QResume resume;

    public QResumeAbility(String variable) {
        this(ResumeAbility.class, forVariable(variable), INITS);
    }

    public QResumeAbility(Path<? extends ResumeAbility> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeAbility(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeAbility(PathMetadata metadata, PathInits inits) {
        this(ResumeAbility.class, metadata, inits);
    }

    public QResumeAbility(Class<? extends ResumeAbility> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.abilitySource = inits.isInitialized("abilitySource") ? new QAbilitySource(forProperty("abilitySource")) : null;
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

