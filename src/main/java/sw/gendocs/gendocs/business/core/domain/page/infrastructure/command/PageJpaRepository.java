package sw.gendocs.gendocs.business.core.domain.page.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;

import java.util.List;

@Repository
public interface PageJpaRepository extends JpaRepository<Page, Long> {

    List<Page> findByFolder(Folder folder);
}
