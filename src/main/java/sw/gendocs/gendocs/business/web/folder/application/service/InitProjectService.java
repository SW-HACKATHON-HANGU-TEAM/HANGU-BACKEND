package sw.gendocs.gendocs.business.web.folder.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.project.entity.Init;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.InitJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestProject;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseInit;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseProject;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadProjectService {
    private final InitJpaRepository initJpaRepository;

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
}
