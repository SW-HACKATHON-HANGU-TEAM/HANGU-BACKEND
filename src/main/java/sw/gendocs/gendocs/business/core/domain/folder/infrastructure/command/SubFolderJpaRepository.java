package sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.folder.entity.SubFolder;

@Repository
public interface SubFolderJpaRepository extends JpaRepository<SubFolder, Long> {
}
