package sw.gendocs.gendocs.business.web.folder.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 프로젝트가 존재하지 않습니다."));
        log.info("project = {}", project);

        Folder save;
        if (requestFolder.getParent() != null) {
//            Folder parentFolder = folderJpaRepository.findById(requestFolder.getParent())
//                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 폴더가 존재하지 않습니다."));
//
//            Folder saveFolder = new Folder(requestFolder.getFolderName(), project);
//            parentFolder.addChild(saveFolder);
//            save = folderJpaRepository.save(parentFolder);
//            save.changeParent(parentFolder);
            Folder parentFolder = folderJpaRepository.findById(requestFolder.getParent())
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 폴더가 존재하지 않습니다."));

            Folder saveFolder = new Folder(requestFolder.getFolderName(), project);
            Folder save1 = folderJpaRepository.save(saveFolder);// save the parent after adding the child
            parentFolder.addChild(save1);

            save = saveFolder; // reference to the saved child

        } else {
            log.info("folderName: {}", requestFolder.getFolderName());
            log.info("project: {}", project.getId());
            Folder saveFolder = new Folder(requestFolder.getFolderName(), project);
            log.info("saveFolder: {}", saveFolder);
            save = folderJpaRepository.save(saveFolder);
        }

        return save.getId();
    }
}
