package com.gs1.ruleengine.model.payload;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiError(
        String message,
        LocalDateTime timestamp
) {
}