package sw.gendocs.gendocs.business.web.project.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.web.project.presentation.response.ResponseProject;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProjectService {

    private final ProjectJpaRepository projectJpaRepository;

    @Transactional(readOnly = true)
    public List<ResponseProject> findProjects() {
        List<Project> projects = projectJpaRepository.findAll();

        List<ResponseProject> responseProjects = new ArrayList<>();

        for (Project project : projects) {
            responseProjects.add(new ResponseProject(project.getId(), project.getProjectName()));
        }

        return responseProjects;
    }
}
