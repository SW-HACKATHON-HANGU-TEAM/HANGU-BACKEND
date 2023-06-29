package sw.gendocs.gendocs.business.web.folder.presentation.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseInit {
    private String mermaid;
    private String dbDescription;
    private String processDescription;
    private String mindMap;

    public ResponseInit(String mermaid, String dbDescription, String processDescription, String mindMap) {
        this.mermaid = mermaid;
        this.dbDescription = dbDescription;
        this.processDescription = processDescription;
        this.mindMap = mindMap;
    }
}
