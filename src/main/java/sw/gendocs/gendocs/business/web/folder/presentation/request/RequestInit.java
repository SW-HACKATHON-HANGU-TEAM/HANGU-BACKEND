package sw.gendocs.gendocs.business.web.folder.presentation.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestInit {
    private String mermaid;
    private String dbDescription;
    private String processDescription;
    private String mindMap;
    private String projectName;
}
