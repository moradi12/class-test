package school.project.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import school.project.Exceptions.SchoolSystemException;

@RestControllerAdvice
public class SchoolControllerAdvice {
    @ExceptionHandler(value = {SchoolSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handleError(Exception e) {
        return new ErrDetails("Error", e.getMessage());
    }
}