package sw.gendocs.gendocs.business.core.domain.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "init")
public class Init {
    @Id
    @Column(name = "init_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mermaid;
    private String dbDescription;
    private String processDescription;
    private String mindMap;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Init(Project project, String mermaid, String dbDescription, String processDescription, String mindMap) {
        this.project = project;
        this.mermaid = mermaid;
        this.dbDescription = dbDescription;
        this.processDescription = processDescription;
        this.mindMap = mindMap;
    }
}
