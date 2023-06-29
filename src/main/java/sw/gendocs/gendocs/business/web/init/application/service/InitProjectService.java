package sw.gendocs.gendocs.business.web.init.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.project.entity.Init;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.InitJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestInit;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseInit;

@Service
@RequiredArgsConstructor
public class InitProjectService {
    private final InitJpaRepository initJpaRepository;
    private final ProjectJpaRepository projectJpaRepository;

    @Transactional
    public ResponseInit getInit(Long initId){
        Init init = initJpaRepository.findById(initId).get();
        ResponseInit responseInit = new ResponseInit();
        responseInit.setMermaid(init.getMermaid());
        responseInit.setDbDescription(init.getDbDescription());
        responseInit.setMindMap(init.getMindMap());
        responseInit.setProcessDescription(init.getProcessDescription());

        return responseInit;
    }

    @Transactional
    public String deleteInit(Long initId){
        Init init = initJpaRepository.findById(initId).get();
        Project project = init.getProject();

        initJpaRepository.deleteById(initId);
        projectJpaRepository.deleteById(project.getId());
        return project.getProjectName();
    }
    @Transactional
    public Long createInit(RequestInit requestInit){
        Project project = new Project();
        project.setProjectName(ProjectName.from(requestInit.getProjectName()));
        Project projectEntity = projectJpaRepository.save(project);
        Init init = new Init(projectEntity, requestInit.getMermaid(), requestInit.getDbDescription(),
                requestInit.getProcessDescription(), requestInit.getMindMap());
        initJpaRepository.save(init);
        return init.getId();
    }
}
