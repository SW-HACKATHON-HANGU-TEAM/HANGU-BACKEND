package sw.gendocs.gendocs.business.core.domain.project.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.project.values.ProjectName;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Project extends DateTime {

    @javax.persistence.Id
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "folder_id")
    private List<Folder> folders = new ArrayList<>();

    @Embedded
    private ProjectName projectName;


    public List<Folder> getFolders() {
        return folders;
    }

    public Project(ProjectName projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName.getProjectName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
