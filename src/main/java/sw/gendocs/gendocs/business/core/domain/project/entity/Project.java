package sw.gendocs.gendocs.business.core.domain.project.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Project extends DateTime {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "folder_id")
    private List<Folder> folders = new ArrayList<>();

    @OneToMany

    public Long getId() {
        return id;
    }

    public List<Folder> getFolders() {
        return folders;
    }
}
