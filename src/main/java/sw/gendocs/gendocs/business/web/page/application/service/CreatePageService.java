package sw.gendocs.gendocs.business.web.page.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.infrastructure.command.FolderJpaRepository;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.core.domain.page.infrastructure.command.PageJpaRepository;
import sw.gendocs.gendocs.business.core.domain.project.values.Description;
import sw.gendocs.gendocs.business.core.domain.project.values.Title;
import sw.gendocs.gendocs.business.web.page.presentation.request.RequestPage;


@Service
@RequiredArgsConstructor
public class CreatePageService {
    private final PageJpaRepository pageJpaRepository;
    private final FolderJpaRepository folderJpaRepository;

    public Long createPage(RequestPage requestPage) {
        Folder folder = folderJpaRepository.findById(requestPage.getFolderId())
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 폴더가 존재하지않습니다."));
        Page page = new Page(
                Title.from(requestPage.getTitle()),
                Description.from(requestPage.getDescription()),
                folder
        );
        return pageJpaRepository.save(page).getId();
    }
}
