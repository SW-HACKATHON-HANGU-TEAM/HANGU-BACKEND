package sw.gendocs.gendocs.business.web.folder.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.gendocs.gendocs.business.web.folder.application.service.FindProjectService;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseProject;
import sw.gendocs.gendocs.common.response.ApiResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/project")
public class FindProjectAPI {

    private final FindProjectService findProjectService;

    @GetMapping
    public ResponseEntity<ApiResponse> findProjects() {
        List<ResponseProject> projects = findProjectService.findProjects();
        return ResponseEntity.ok()
                .body(ApiResponse.of(projects));
    }
}
