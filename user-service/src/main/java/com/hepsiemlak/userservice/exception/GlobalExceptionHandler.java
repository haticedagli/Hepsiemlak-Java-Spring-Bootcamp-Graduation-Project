package com.hepsiemlak.userservice.exception;

import com.hepsiemlak.userservice.model.error.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDto> handleException(HttpServletRequest request, BaseException exception) {
        LOGGER.error("Exception: ", exception);
        ErrorDto throwableProblem = buildProblem(request, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(throwableProblem, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(HttpServletRequest request, NotFoundException exception) {
        LOGGER.error("Exception: ", exception);
        ErrorDto throwableProblem = buildProblem(request, HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(throwableProblem, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto> handleException(HttpServletRequest request, BadRequestException exception) {
        LOGGER.error("Exception: ", exception);
        ErrorDto throwableProblem = buildProblem(request, HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(throwableProblem, HttpStatus.BAD_REQUEST);
    }

    private ErrorDto buildProblem(HttpServletRequest request, HttpStatus statusType, String exceptionDetailMessage) {
        ErrorDto problem = new ErrorDto();
        problem.setStatus(statusType.value());
        problem.setTitle(statusType.getReasonPhrase());
        problem.setDetail(exceptionDetailMessage);
        problem.setMessage(exceptionDetailMessage);
        problem.setRequestUri(request.getRequestURI());
        problem.setRequestMethod(request.getMethod());
        problem.setInstant(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
        return problem;
    }
}
