package sw.gendocs.gendocs.business.web.folder.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.gendocs.gendocs.business.web.folder.application.service.CreateProjectService;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestProject;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseProject;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/project")
public class CreateProjectAPI {

    private final CreateProjectService createProjectService;

    @PostMapping
    public ResponseEntity<ApiResponse> createProject(@Valid @RequestBody RequestProject requestProject) {
        ResponseProject project = createProjectService.createProject(requestProject);
        return ResponseEntity.ok()
                .body(ApiResponse.of(project));
    }
}
