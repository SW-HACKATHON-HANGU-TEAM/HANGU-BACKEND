package sw.gendocs.gendocs.business.core.domain.folder.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class SubFolder {

    @javax.persistence.Id
    @Id
    @Column(name = "subfolder_id")
    private Long id;


    @Column(name = "folder_name")
    private String folderName;

    @ManyToOne
    private Folder parent;

    public SubFolder(
            Long id,
            String folderName,
            Folder parent
    ) {
        this.id = id;
        this.folderName = folderName;
        this.parent = parent;
    }


    public String getFolderName() {
        return folderName;
    }

    public Folder getParent() {
        return parent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
