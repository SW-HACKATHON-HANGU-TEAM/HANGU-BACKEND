package sw.gendocs.gendocs.business.core.domain.folder.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFolder is a Querydsl query type for Folder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFolder extends EntityPathBase<Folder> {

    private static final long serialVersionUID = -1248706638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFolder folder = new QFolder("folder");

    public final sw.gendocs.gendocs.business.core.domain.common.date.QDateTime _super = new sw.gendocs.gendocs.business.core.domain.common.date.QDateTime(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final ListPath<sw.gendocs.gendocs.business.core.domain.page.entity.Page, sw.gendocs.gendocs.business.core.domain.page.entity.QPage> pages = this.<sw.gendocs.gendocs.business.core.domain.page.entity.Page, sw.gendocs.gendocs.business.core.domain.page.entity.QPage>createList("pages", sw.gendocs.gendocs.business.core.domain.page.entity.Page.class, sw.gendocs.gendocs.business.core.domain.page.entity.QPage.class, PathInits.DIRECT2);

    public final QFolder parent;

    public final sw.gendocs.gendocs.business.core.domain.project.entity.QProject project;

    public final ListPath<Folder, QFolder> subFolders = this.<Folder, QFolder>createList("subFolders", Folder.class, QFolder.class, PathInits.DIRECT2);

    public QFolder(String variable) {
        this(Folder.class, forVariable(variable), INITS);
    }

    public QFolder(Path<? extends Folder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFolder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFolder(PathMetadata metadata, PathInits inits) {
        this(Folder.class, metadata, inits);
    }

    public QFolder(Class<? extends Folder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QFolder(forProperty("parent"), inits.get("parent")) : null;
        this.project = inits.isInitialized("project") ? new sw.gendocs.gendocs.business.core.domain.project.entity.QProject(forProperty("project")) : null;
    }

}

