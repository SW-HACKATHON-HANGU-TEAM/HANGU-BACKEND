package sw.gendocs.gendocs.business.web.page.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sw.gendocs.gendocs.business.core.domain.page.entity.Page;
import sw.gendocs.gendocs.business.core.domain.page.infrastructure.command.PageJpaRepository;
import sw.gendocs.gendocs.business.web.page.presentation.response.ResponsePage;


@Service
@RequiredArgsConstructor
public class FindPageService {

    private final PageJpaRepository pageJpaRepository;

    public ResponsePage findPageById(Long id) {
        Page page = pageJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 페이지가 존재하지 않습니다."));

        return new ResponsePage(
                page.getId(),
                page.getTitle(),
                page.getDescription().getDescription()
        );
    }
}
