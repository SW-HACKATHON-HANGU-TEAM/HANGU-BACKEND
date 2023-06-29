package sw.gendocs.gendocs.business.core.domain.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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

    @javax.persistence.Id
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
