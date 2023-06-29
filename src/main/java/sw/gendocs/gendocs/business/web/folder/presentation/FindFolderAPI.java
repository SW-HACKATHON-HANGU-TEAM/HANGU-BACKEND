package sw.gendocs.gendocs.business.web.folder.presentation;

import io.micrometer.core.lang.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.gendocs.gendocs.business.web.folder.application.service.FindFolderService;
import sw.gendocs.gendocs.business.web.folder.presentation.response.ResponseFolder;
import sw.gendocs.gendocs.common.response.ApiResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/folder")
public class FindFolderAPI {

    private final FindFolderService findFolderService;

    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse> findFolder(
            @PathVariable("projectId") Long projectId,
            @Nullable @RequestParam Long folderId
    ) {
        List<ResponseFolder> responseFolderList = findFolderService.findFolderListByProjectId(projectId, folderId);
        return ResponseEntity
                .ok()
                .body(ApiResponse.of(responseFolderList));
    }
}
