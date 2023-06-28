package sw.gendocs.gendocs.business.core.domain.page.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPage is a Querydsl query type for Page
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPage extends EntityPathBase<Page> {

    private static final long serialVersionUID = 891612596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPage page = new QPage("page");

    public final sw.gendocs.gendocs.business.core.domain.common.date.QDateTime _super = new sw.gendocs.gendocs.business.core.domain.common.date.QDateTime(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    public final sw.gendocs.gendocs.business.core.domain.project.values.QDescription description;

    public final sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder folder;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final sw.gendocs.gendocs.business.core.domain.project.values.QTitle title;

    public QPage(String variable) {
        this(Page.class, forVariable(variable), INITS);
    }

    public QPage(Path<? extends Page> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPage(PathMetadata metadata, PathInits inits) {
        this(Page.class, metadata, inits);
    }

    public QPage(Class<? extends Page> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.description = inits.isInitialized("description") ? new sw.gendocs.gendocs.business.core.domain.project.values.QDescription(forProperty("description")) : null;
        this.folder = inits.isInitialized("folder") ? new sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder(forProperty("folder"), inits.get("folder")) : null;
        this.title = inits.isInitialized("title") ? new sw.gendocs.gendocs.business.core.domain.project.values.QTitle(forProperty("title")) : null;
    }

}

