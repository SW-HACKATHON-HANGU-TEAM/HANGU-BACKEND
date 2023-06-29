package sw.gendocs.gendocs.business.web.page.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.gendocs.gendocs.business.web.page.application.service.FindPageService;
import sw.gendocs.gendocs.business.web.page.presentation.response.ResponsePage;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/page")
public class FindPageAPI {

    private final FindPageService findPageService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id) {
        ResponsePage pageById = findPageService.findPageById(id);
        return ResponseEntity
                .ok()
                .body(ApiResponse.of(pageById));
    }
}
