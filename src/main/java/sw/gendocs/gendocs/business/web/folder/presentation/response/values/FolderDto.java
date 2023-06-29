package sw.gendocs.gendocs.business.web.folder.presentation.response.values;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FolderDto {

    private Long id;
    private String title;

    public FolderDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
