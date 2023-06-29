package sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;

@Repository
public interface FolderJpaRepository extends JpaRepository<Folder, Long> {

}
