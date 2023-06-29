package sw.gendocs.gendocs.business.web.folder.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.HSQLSqlAstTranslator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command.FolderJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestFolder;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateFolderService {

    private final FolderJpaRepository folderJpaRepository;
    private final ProjectJpaRepository projectJpaRepository;

    @Transactional
    public Long createFolder(RequestFolder requestFolder) {
        Project project = projectJpaRepository.findById(requestFolder.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("해당 id값의 프로젝트가 존재하지 않습니다."));

        Folder parent = null;
        if (requestFolder.getParent() != null) {
            parent = folderJpaRepository.findById(requestFolder.getParent())
                    .orElseThrow(() -> new IllegalArgumentException("해당 id값의 부모 폴더가 존재하지 않습니다."));
        }


        Folder folder = new Folder(
                requestFolder.getFolderName(),
                parent,
                project
        );

        Folder savedFolder = folderJpaRepository.save(folder);
        return savedFolder.getId();
    }
}
