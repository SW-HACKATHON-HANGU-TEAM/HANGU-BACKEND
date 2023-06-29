package sw.gendocs.gendocs.business.core.domain.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "folder_id")
    private List<Folder> folders = new ArrayList<>();

    @OneToOne(mappedBy = "project")
    private Init init;

    @Embedded
    private ProjectName projectName;

    @OneToMany

    public Long getId() {
        return id;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public Project(ProjectName projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName.getProjectName();
    }
}
