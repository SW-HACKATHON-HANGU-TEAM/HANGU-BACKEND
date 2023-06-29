package sw.gendocs.gendocs.business.core.domain.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project extends DateTime {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ProjectName projectName;

    public Long getId() {
        return id;
    }

    public Project(ProjectName projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName.getProjectName();
    }
}
