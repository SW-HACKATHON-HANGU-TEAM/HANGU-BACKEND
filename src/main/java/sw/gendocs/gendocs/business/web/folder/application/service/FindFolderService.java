package sw.gendocs.gendocs.business.web.folder.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command.FolderJpaRepository;
import sw.gendocs.gendocs.business.core.domain.folder.infrastructure.query.FolderQuery;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.core.domain.page.infrastructure.command.PageJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;
import sw.gendocs.gendocs.business.core.domain.project.infrastructure.command.ProjectJpaRepository;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseFolder;
import sw.gendocs.gendocs.business.web.folder.presentation.response.values.FolderDto;
import sw.gendocs.gendocs.business.web.folder.presentation.response.values.PageDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindFolderService {

    private final FolderQuery folderQuery;
    private final ProjectJpaRepository projectJpaRepository;
    private final FolderJpaRepository folderJpaRepository;
    private final PageJpaRepository pageJpaRepository;

    public ResponseFolder findByProjectIdAndFolderId(Long projectId, Long folderId) {
        List<Folder> folders = new ArrayList<>();
        Folder folder;
        Project project = projectJpaRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id값의 프로젝트가 존재하지 않습니다."));

        List<PageDto> pageDtos = new ArrayList<>();

        if (folderId == null || folderId < 1) {
            folders = folderQuery.findByProject(project);
        } else {
            folder = folderJpaRepository.findById(folderId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id값의 폴더가 존재하지 않습니다."));
            folders = folderQuery.findByProjectAndParentFolder(project, folder);
            List<Page> pages = pageJpaRepository.findByFolder(folder);

            log.info("pages size: {}", pages.size());

            for (Page page : pages) {
                PageDto pageDto = new PageDto(page.getId(), page.getTitle());
                pageDtos.add(pageDto);
            }
        }

        List<FolderDto> folderDtos = new ArrayList<>();
        for (Folder folder1 : folders) {
            FolderDto folderDto = new FolderDto(folder1.getId(), folder1.getFolderName());
            folderDtos.add(folderDto);
        }

        ResponseFolder responseFolder = new ResponseFolder(folderDtos, pageDtos);
        return responseFolder;
    }
}
