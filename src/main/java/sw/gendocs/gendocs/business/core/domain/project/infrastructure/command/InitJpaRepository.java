package sw.gendocs.gendocs.business.core.domain.project.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.project.entity.Init;

@Repository
public interface InitJpaRepository extends JpaRepository<Init, Long> {
}
