package com.gs1.ruleengine.config;

import com.gs1.ruleengine.model.exception.RecordNotFoundException;
import com.gs1.ruleengine.model.payload.ApiError;
import com.gs1.ruleengine.model.payload.ApiResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Global RestFul APIs exception advisor
 *
 * @author Mahmoud Shtayeh
 */
@NoArgsConstructor
@RestControllerAdvice
public class GlobalExceptionAdvisor {
    /**
     * UnKnown exceptions handler
     *
     * @param exception UnKnown exception
     * @return ApiResponse wrapping the error user-friendly details
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse<Object>> handleException(final Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(ApiError.builder()
                        .message(exception.getMessage())
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
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ApiError.builder()
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()));
    }
}