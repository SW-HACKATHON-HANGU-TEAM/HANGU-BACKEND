package sw.gendocs.gendocs.business.core.domain.page.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;

@Repository
public interface PageJpaRepository extends JpaRepository<Page, Long> {
}
