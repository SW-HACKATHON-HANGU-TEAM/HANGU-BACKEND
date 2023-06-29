package sw.gendocs.gendocs.business.core.domain.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private List<Folder> folders = new ArrayList<>();


    public Project(ProjectName projectName) {
        this.projectName = projectName;
    }

    public List<Folder> getFolders() {
        return folders;
    }


    public String getProjectName() {
        return projectName.getProjectName();
    }

    public Long getId() {
        return id;
    }
}
