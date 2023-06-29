package sw.gendocs.gendocs.business.core.domain.page.entity;

import lombok.NoArgsConstructor;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.folder.entity.Folder;
import sw.gendocs.gendocs.business.core.domain.project.values.Description;
import sw.gendocs.gendocs.business.core.domain.project.values.Title;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Page extends DateTime {

    @Id
    @Column(name = "page_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;


    public String getTitle() {
        return title.getTitle();
    }

    public Description getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public Folder getFolder() {
        return folder;
    }

    public Page(Title title, Description description, Folder folder) {
        this.title = title;
        this.description = description;
        this.folder = folder;
    }
}
