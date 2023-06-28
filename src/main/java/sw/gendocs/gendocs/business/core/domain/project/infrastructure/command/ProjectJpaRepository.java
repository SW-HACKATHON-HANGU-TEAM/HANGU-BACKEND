package sw.gendocs.gendocs.business.core.domain.project.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
}
