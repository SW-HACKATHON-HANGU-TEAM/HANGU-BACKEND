package sw.gendocs.gendocs.business.core.domain.page.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import sw.gendocs.gendocs.business.core.domain.common.date.DateTime;
import sw.gendocs.gendocs.business.core.domain.project.values.Description;
import sw.gendocs.gendocs.business.core.domain.project.values.Title;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Page extends DateTime {

    @javax.persistence.Id
    @Id
    @Column(name = "page_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
