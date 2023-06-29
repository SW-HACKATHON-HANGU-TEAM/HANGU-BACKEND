package sw.gendocs.gendocs.business.web.folder.presentation;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.gendocs.gendocs.business.web.folder.application.service.CreateProjectService;
import sw.gendocs.gendocs.business.web.folder.application.service.ReadProjectService;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestProject;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseInit;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseProject;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class ReadProjectAPI {
    private final ReadProjectService readProjectService;

    @GetMapping("/init/{initId}")
    public ResponseEntity<ApiResponse> getInit(@PathVariable("initId") Long initId) {
        ResponseInit init = readProjectService.getInit(initId);
        return ResponseEntity.ok()
                .body(ApiResponse.of(init));
    }
}
