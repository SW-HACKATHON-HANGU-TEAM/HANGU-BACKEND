package sw.gendocs.gendocs.business.core.domain.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInit is a Querydsl query type for Init
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInit extends EntityPathBase<Init> {

    private static final long serialVersionUID = 177426861L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInit init = new QInit("init");

    public final StringPath dbDescription = createString("dbDescription");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mermaid = createString("mermaid");

    public final StringPath mindMap = createString("mindMap");

    public final StringPath processDescription = createString("processDescription");

    public final QProject project;

    public QInit(String variable) {
        this(Init.class, forVariable(variable), INITS);
    }

    public QInit(Path<? extends Init> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInit(PathMetadata metadata, PathInits inits) {
        this(Init.class, metadata, inits);
    }

    public QInit(Class<? extends Init> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

