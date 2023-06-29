package sw.gendocs.gendocs.business.web.init.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.gendocs.gendocs.business.web.init.application.service.InitProjectService;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestInit;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseInit;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class InitProjectAPI {
    private final InitProjectService initProjectService;

    @GetMapping("/init/{initId}")
    public ResponseEntity<ApiResponse> getInit(@PathVariable("initId") Long initId) {
        ResponseInit init = initProjectService.getInit(initId);
        return ResponseEntity.ok()
                .body(ApiResponse.of(init));
    }
    @DeleteMapping("/init/{initId}")
    public ResponseEntity<ApiResponse> deleteInit(@PathVariable("initId") Long initId) {
        return ResponseEntity.ok()
                .body(ApiResponse.of(initProjectService.deleteInit(initId)));
    }
    @PostMapping("/init")
    public ResponseEntity<ApiResponse> createInit(@RequestBody RequestInit requestInit) {
        return ResponseEntity.ok()
                .body(ApiResponse.of(initProjectService.createInit(requestInit)));
    }
}
