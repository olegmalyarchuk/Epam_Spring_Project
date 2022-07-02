package com.epam.spring.web.mvc.conferences;

import com.epam.spring.web.mvc.conferences.exception.ServiceException;
import com.epam.spring.web.mvc.conferences.persistence.model.Error;
import com.epam.spring.web.mvc.conferences.persistence.model.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(Exception exception) {
        log.error("handleException: message {}", exception.getMessage());
        return new Error(exception.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException serviceException) {
        log.error("handleServiceException: message {}", serviceException.getMessage());
        return new Error(serviceException.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMthodArgumentNotValidException: message {}", e.getMessage());
        return e.getBindingResult().getAllErrors().stream().map(
                err -> new Error(
                        err.getDefaultMessage(),
                        ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now())
        ).collect(Collectors.toList());
    }

}
