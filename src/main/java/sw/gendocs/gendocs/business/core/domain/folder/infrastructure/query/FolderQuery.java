package sw.gendocs.gendocs.business.core.domain.folder.infrastructure.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;

import java.util.List;

import static sw.gendocs.gendocs.business.core.domain.folder.entity.QFolder.folder;


@Slf4j
@Repository
public class FolderQuery {

    private final JPAQueryFactory queryFactory;

    public FolderQuery(JPAQueryFactory jpaQueryFactory) {
        this.queryFactory = jpaQueryFactory;
    }

    public List<Folder> findByProjectAndParentFolder(Project project, Folder parent) {
        log.info("findByProjectAndParentFolder start");
        List<Folder> fetch = queryFactory.select(folder)
                .from(folder)
                .where(
                        folder.project.eq(project)
                                .and(folder.parent.eq(parent))
                ).fetch();

        return fetch;
    }

    public List<Folder> findByProject(Project project) {
        log.info("findByProject start");

        List<Folder> fetch = queryFactory.select(folder)
                .from(folder)
                .where(
                        folder.project.eq(project)
                                .and(folder.parent.isNull())
                )
                .fetch();
        log.info("findByProject size: {}", fetch.size());
        return fetch;
    }
}
