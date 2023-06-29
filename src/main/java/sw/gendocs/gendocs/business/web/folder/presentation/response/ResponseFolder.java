package sw.gendocs.gendocs.business.web.folder.presentation.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.web.page.presentation.response.ResponsePage;

import java.util.ArrayList;
import java.util.List;

import static sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseSubFolder.*;
import static sw.gendocs.gendocs.business.web.page.presentation.response.ResponsePage.pageToResponseDTO;

@Data
@NoArgsConstructor
public class ResponseFolder {

    private Long id;
    private String parent;
    private List<ResponsePage> pages = new ArrayList<>();
    private List<ResponseSubFolder> subFolders = new ArrayList<>();

    public ResponseFolder(Long id, String parent, List<ResponsePage> pages, List<ResponseSubFolder> subFolders) {
        this.id = id;
        this.parent = parent == null ? null : parent;
        this.pages = pages;
        this.subFolders = subFolders;
    }

    public static ResponseFolder folderToResponseDTO(Folder folder, List<Folder> subFolder) {
        List<Page> pages = folder.getPages();
        List<ResponsePage> responsePageList = new ArrayList<>();

        for (Page page : pages) {
            responsePageList.add(pageToResponseDTO(page));
        }
        return new ResponseFolder(
                folder.getId(),
                folder.getFolderName(),
                responsePageList,
                folderToSubFolderDTO(subFolder)
        );

    }
}
