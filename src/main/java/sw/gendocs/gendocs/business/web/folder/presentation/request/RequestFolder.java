package sw.gendocs.gendocs.business.web.folder.presentation.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * {
 * 	"folderName": "<새로 만들 폴더 이름>",
 * 	"parent": 1, // 부모 폴더 id값 (root폴더면 null)
 * 	"projectId": 3 // 저장하는 프로젝트의 id값
 * }
 */
@Data
@NoArgsConstructor
public class RequestFolder {


    @NotNull
    private Long projectId;
    private Long parent;
    @NotNull
    private String folderName;

}
