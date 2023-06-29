package sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;

import java.util.List;

@Repository
public interface FolderJpaRepository extends JpaRepository<Folder, Long> {

//    List<Folder> findByProject(Project project);
    List<Folder> findByProject(Project project);
    List<Folder> findByProject(Project project, Folder folder);
}
