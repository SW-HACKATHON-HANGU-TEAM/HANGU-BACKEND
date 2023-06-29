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

    public static final QProject project = new QProject("project");

    public final sw.gendocs.gendocs.business.core.domain.common.date.QDateTime _super = new sw.gendocs.gendocs.business.core.domain.common.date.QDateTime(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final ListPath<sw.gendocs.gendocs.business.core.domain.folder.entity.Folder, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder> folders = this.<sw.gendocs.gendocs.business.core.domain.folder.entity.Folder, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder>createList("folders", sw.gendocs.gendocs.business.core.domain.folder.entity.Folder.class, sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final StringPath projectName = createString("projectName");

    public QProject(String variable) {
        super(Project.class, forVariable(variable));
    }

    public QProject(Path<? extends Project> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProject(PathMetadata metadata) {
        super(Project.class, metadata);
    }

}

