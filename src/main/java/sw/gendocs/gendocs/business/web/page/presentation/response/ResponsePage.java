package sw.gendocs.gendocs.business.web.page.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePage {

    private Long id;
    private String title;
    private String description;

    public static ResponsePage pageToResponseDTO(Page page) {
        return new ResponsePage(
                page.getId(),
                page.getTitle().getTitle(),
                page.getDescription().getDescription()
        );
    }
}
