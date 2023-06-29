package sw.gendocs.gendocs.business.web.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.gendocs.gendocs.business.web.project.application.service.CreateProjectService;
import sw.gendocs.gendocs.business.web.project.presentation.request.RequestProject;
import sw.gendocs.gendocs.business.web.project.presentation.response.ResponseProject;
import sw.gendocs.gendocs.common.response.ApiResponse;

import javax.validation.Valid;

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
