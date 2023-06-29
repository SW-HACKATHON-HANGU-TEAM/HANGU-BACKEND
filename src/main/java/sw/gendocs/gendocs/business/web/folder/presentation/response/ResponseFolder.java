package sw.gendocs.gendocs.business.web.folder.presentation.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.web.folder.presentation.response.values.FolderDto;
import sw.gendocs.gendocs.business.web.folder.presentation.response.values.PageDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseFolder {
    private List<FolderDto> folders;
    private List<PageDto> pages;

    public ResponseFolder(List<FolderDto> folders, List<PageDto> pages) {
        this.folders = folders;
        this.pages = pages;
    }
}
