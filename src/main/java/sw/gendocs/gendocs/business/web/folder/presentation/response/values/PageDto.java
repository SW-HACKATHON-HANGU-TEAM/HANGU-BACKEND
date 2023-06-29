package sw.gendocs.gendocs.business.web.folder.presentation.response.values;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDto {
    private Long id;
    private String title;

    public PageDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
