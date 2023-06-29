package sw.gendocs.gendocs.business.web.project.presentation.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RequestProject {

    @NotNull(message = "null값을 넣으면 안됩니다.")
    @Size(min = 5, max = 50, message = "프로젝트의 이름은 5 ~ 50글자 사이로 입력해주세요.")
    private String projectName;

    public RequestProject(String projectName) {
        this.projectName = projectName;
    }
}
