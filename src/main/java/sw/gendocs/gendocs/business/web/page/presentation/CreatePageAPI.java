package sw.gendocs.gendocs.business.web.page.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.gendocs.gendocs.business.web.page.application.service.CreatePageService;
import sw.gendocs.gendocs.business.web.page.presentation.request.RequestPage;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/page")
public class CreatePageAPI {

    private final CreatePageService createPageService;

    @PostMapping
    public ResponseEntity<ApiResponse> createPage(@RequestBody RequestPage requestPage) {
        Long page = createPageService.createPage(requestPage);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.of(page));
    }
}
