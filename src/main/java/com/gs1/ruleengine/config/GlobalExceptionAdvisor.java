package com.gs1.ruleengine.config;

import com.gs1.ruleengine.model.exception.RecordNotFoundException;
import com.gs1.ruleengine.model.payload.ApiError;
import com.gs1.ruleengine.model.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Global RestFul APIs exception advisor
 *
 * @author Mahmoud Shtayeh
 */
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionAdvisor {
    /**
     * I8n supported messages source
     */
    private final MessageSource messageSource;

    /**
     * UnKnown exceptions handler
     *
     * @param exception UnKnown exception
     * @return ApiResponse wrapping the error user-friendly details
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse<Object>> handleException(final Exception exception) {
        final String message = messageSource
                .getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(ApiError.builder()
                        .message(message)
                        .timestamp(LocalDateTime.now())
                        .build()));
    }

    /**
     * RecordNotFoundException exception handler
     *
     * @param exception RecordNotFoundException exception
     * @return ApiResponse wrapping the error user-friendly details
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleRecordNotFoundException(final RecordNotFoundException exception) {
        final String message = messageSource
                .getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ApiError.builder()
                        .message(message)
                        .timestamp(LocalDateTime.now())
                        .build()));
    }

    /**
     * MethodArgumentNotValidException exception handler
     *
     * @param exception MethodArgumentNotValidException exception
     * @return ApiResponse wrapping the error user-friendly details
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(final MethodArgumentNotValidException exception) {
        final List<ApiError> apiErrors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(apiError -> apiErrors.add(ApiError.builder()
                .message(messageSource.getMessage(Objects.requireNonNull(apiError.getDefaultMessage()),
                        null, LocaleContextHolder.getLocale()))
                .timestamp(LocalDateTime.now())
                .build()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.builder()
                        .errors(apiErrors)
                        .build());
    }
}