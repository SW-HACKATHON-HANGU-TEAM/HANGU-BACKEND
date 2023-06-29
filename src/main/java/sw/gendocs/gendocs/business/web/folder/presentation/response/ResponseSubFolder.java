package sw.gendocs.gendocs.business.web.folder.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.folder.entity.SubFolder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSubFolder {

    private Long id;
    private String title;

    public static List<ResponseSubFolder> folderToSubFolderDTO(List<Folder> folder) {
        List<ResponseSubFolder> subFolders = new ArrayList<>();
        for (Folder subFolder : folder) {
            subFolders.add(new ResponseSubFolder(subFolder.getId(), subFolder.getFolderName()));
        }
        return subFolders;
    }
}
