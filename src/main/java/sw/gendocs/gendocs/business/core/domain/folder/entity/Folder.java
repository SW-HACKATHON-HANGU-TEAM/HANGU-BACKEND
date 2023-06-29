package sw.gendocs.gendocs.business.core.domain.folder.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.core.domain.project.entity.Project;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Folder extends DateTime {

    @Id
    @Column(name = "folder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_folder_id")
    private List<Folder> subFolders = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "folder")
    private List<Page> pages = new ArrayList<>();

    @Column(name = "folder_name")
    private String folderName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Folder parent;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Long getId() {
        return id;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public List<Page> getPages() {
        return pages;
    }

    public Folder getParent() {
        return parent;
    }

    public String getFolderName() {
        return folderName;
    }

    public Project getProject() {
        return project;
    }

    public Folder(String folderName, Folder parent, Project project) {
        this.folderName = folderName;
        if (parent != null) {
            this.parent = parent;
        }
        if (project != null) {
            this.project = project;
        }
    }
}
