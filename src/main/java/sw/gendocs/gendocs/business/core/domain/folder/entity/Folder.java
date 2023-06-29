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


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "folder")
    private List<Page> pages = new ArrayList<>();

    @Column(name = "folder_name")
    private String folderName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Folder parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Folder> children = new ArrayList<>();



    public Long getId() {
        return id;
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

    public Folder(String folderName, Project project) {
        this.folderName = folderName;
        this.project = project;
    }

    public Folder(String folderName, Project project, Folder parent) {
        this.folderName = folderName;
        this.project = project;
        this.parent = parent;
    }

    public Folder getParent() {
        return parent;
    }

    public void changeParent(Folder parent) {
        this.parent = parent;
    }

    public void addChild(Folder child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }
}
