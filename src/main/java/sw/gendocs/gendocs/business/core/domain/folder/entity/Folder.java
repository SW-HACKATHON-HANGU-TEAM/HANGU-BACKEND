package sw.gendocs.gendocs.business.core.domain.folder.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Folder extends DateTime implements Serializable {

    @javax.persistence.Id
    @Id
    @Column(name = "folder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_folder_id")
    private List<SubFolder> subFolders = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "folder")
    private List<Page> pages = new ArrayList<>();

    @Column(name = "folder_name")
    private String folderName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Long getId() {
        return id;
    }

    public List<SubFolder> getSubFolders() {
        return subFolders;
    }

    public List<Page> getPages() {
        return pages;
    }

    public String getFolderName() {
        return folderName;
    }

    public Project getProject() {
        return project;
    }

    public Folder(String folderName, Folder parent, Project project) {
        this.folderName = folderName;
        if (project != null) {
            this.project = project;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}
