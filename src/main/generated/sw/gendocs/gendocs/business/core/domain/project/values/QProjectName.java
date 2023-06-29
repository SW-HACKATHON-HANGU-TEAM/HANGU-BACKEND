package sw.gendocs.gendocs.business.core.domain.project.values;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProjectName is a Querydsl query type for ProjectName
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QProjectName extends BeanPath<ProjectName> {

    private static final long serialVersionUID = 346419398L;

    public static final QProjectName projectName1 = new QProjectName("projectName1");

    public final StringPath projectName = createString("projectName");

    public QProjectName(String variable) {
        super(ProjectName.class, forVariable(variable));
    }

    public QProjectName(Path<? extends ProjectName> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectName(PathMetadata metadata) {
        super(ProjectName.class, metadata);
    }

}

