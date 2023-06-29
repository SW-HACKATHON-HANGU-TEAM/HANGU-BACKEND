package sw.gendocs.gendocs.business.core.domain.project.values;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProjectName {

    private String projectName;

    protected ProjectName() {

    }

    private ProjectName(String projectName) {
        validate(projectName);
        this.projectName = projectName;
    }

    private void validate(String projectName) {
        if (projectName == null) {
            throw new IllegalArgumentException("프로젝트 이름에 null값을 입력하셨습니다.");
        }

        if (projectName.length() < 5 || projectName.length() > 50) {
            throw new IllegalArgumentException("프로젝트 이름은 5글자에서 50글자 사이로 만들어주세요.");
        }
    }

    public static ProjectName from(String projectName) {
        return new ProjectName(projectName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectName that)) return false;
        return Objects.equals(projectName, that.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }

    @Override
    public String toString() {
        return projectName;
    }

    public String getProjectName() {
        return projectName;
    }
}
