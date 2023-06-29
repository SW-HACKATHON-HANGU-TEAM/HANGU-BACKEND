package sw.gendocs.gendocs.business.core.domain.project.entity;

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

    private static final long serialVersionUID = 656293212L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProject project = new QProject("project");

    public final sw.gendocs.gendocs.business.core.domain.common.date.QDateTime _super = new sw.gendocs.gendocs.business.core.domain.common.date.QDateTime(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final ListPath<sw.gendocs.gendocs.business.core.domain.folder.entity.Folder, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder> folders = this.<sw.gendocs.gendocs.business.core.domain.folder.entity.Folder, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder>createList("folders", sw.gendocs.gendocs.business.core.domain.folder.entity.Folder.class, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QInit init;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final StringPath projectName = createString("projectName");

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
        this.init = inits.isInitialized("init") ? new QInit(forProperty("init"), inits.get("init")) : null;
    }

}

