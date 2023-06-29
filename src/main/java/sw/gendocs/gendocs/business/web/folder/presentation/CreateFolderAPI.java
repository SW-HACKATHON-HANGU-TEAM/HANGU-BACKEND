package sw.gendocs.gendocs.business.web.folder.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.gendocs.gendocs.business.web.folder.application.service.CreateFolderService;
import sw.gendocs.gendocs.business.web.folder.presentation.request.RequestFolder;
import sw.gendocs.gendocs.common.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/folder")
public class CreateFolderAPI {

    private final CreateFolderService createFolderService;

    @PostMapping
    public ResponseEntity<ApiResponse> createFolder(@RequestBody RequestFolder requestFolder) {
        Long folderId = createFolderService.createFolder(requestFolder);
        return ResponseEntity
                .ok()
                .body(ApiResponse.of(folderId));
    }
}
