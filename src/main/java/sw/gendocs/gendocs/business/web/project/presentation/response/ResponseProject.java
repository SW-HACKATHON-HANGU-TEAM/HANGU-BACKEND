package sw.gendocs.gendocs.business.web.project.presentation.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProject {

    private Long projectId;
    private String projectName;

    public ResponseProject(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }
}
