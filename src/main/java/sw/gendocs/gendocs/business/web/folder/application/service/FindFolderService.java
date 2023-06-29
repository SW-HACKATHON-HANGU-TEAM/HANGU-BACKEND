package sw.gendocs.gendocs.business.web.folder.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.entity.SubFolder;
import sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command.FolderJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseFolder;

import java.util.ArrayList;
import java.util.List;

import static sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseFolder.folderToResponseDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindFolderService {

    private final FolderJpaRepository folderJpaRepository;
    private final ProjectJpaRepository projectJpaRepository;

    @Transactional(readOnly = true)
    public List<ResponseFolder> findFolderListByProjectId(Long projectId, Long folderId) {
        if (projectId == null) {
            throw new IllegalArgumentException("프로젝트 id값은 null이면 안됩니다.");
        }

        Project project = projectJpaRepository.findById(projectId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id값의 프로젝트가 존재하지 않습니다."));

        List<Folder> folderList = folderId == null ?
                folderJpaRepository
                        .findByProject(project) : getFolderListByParentIdAndProject(folderId, project);

        List<ResponseFolder> responseFolderList = new ArrayList<>();
        for (Folder folder : folderList) {
            List<Folder> subFolderList = new ArrayList<>();
            List<SubFolder> subFolders = folder.getSubFolders();
            log.info("subFolder size: {}", subFolders.size());
            for (SubFolder subFolder : subFolders) {
                Folder sub = folderJpaRepository.findById(subFolder.getId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 id값의 서브폴더가 존재하지 않습니다."));
                subFolderList.add(sub);
            }
            ResponseFolder responseFolder = folderToResponseDTO(folder, subFolderList);
            responseFolderList.add(responseFolder);
        }

        return responseFolderList;
    }

    public List<Folder> getFolderListByParentIdAndProject(Long folderId, Project project) {
        List<Folder> folderList;
        Folder parent = folderJpaRepository.findById(folderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id값의 부모폴더는 존재하지 않습니다."));
//        List<SubFolder> subFolders = parent.getSubFolders();
//
//        List<Folder> subFolderList = new ArrayList<>();
//        for (SubFolder subFolder : subFolders) {
//            Folder folder = folderJpaRepository.findById(subFolder.getId())
//                    .orElseThrow(() -> new IllegalArgumentException("해당 id값의 서브폴더가 존재하지 않습니다."));
//            subFolderList.add(folder);
//        }

        folderList = folderJpaRepository.findByProject(project, parent);

        return folderList;
    }

}
