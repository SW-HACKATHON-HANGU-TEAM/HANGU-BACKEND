package sw.gendocs.gendocs.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sw.gendocs.gendocs.common.exception.common.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse catchIllegalArgumentException(IllegalArgumentException exception) {
        log.info("IllegalArgumentException: {}", exception.getMessage());
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, exception.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ErrorResponse catchRuntimeException(IllegalArgumentException exception) {
        log.info("RuntimException: {}", exception.getMessage());
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
