package sw.gendocs.gendocs.business.web.page.presentation.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestPage {

    private Long folderId;
    private String title;
    private String description;
}
