package sw.gendocs.gendocs.business.web.project.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;
import sw.gendocs.gendocs.business.web.project.presentation.request.RequestProject;
import sw.gendocs.gendocs.business.web.project.presentation.response.ResponseProject;


@Service
@RequiredArgsConstructor
public class CreateProjectService {

    private final ProjectJpaRepository projectJpaRepository;

    @Transactional
    public ResponseProject createProject(RequestProject requestProject) {
        Project project = new Project(
                ProjectName.from(requestProject.getProjectName())
        );

        projectJpaRepository.save(project);

        return new ResponseProject(
                project.getId(),
                project.getProjectName()
        );
    }
}
