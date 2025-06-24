package com.gs1.ruleengine.model.payload;

import lombok.*;

import java.util.List;

/**
 * Rest API response wrapper
 *
 * @param <P> API payload type
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<P> {
    /**
     * Rest API payload
     */
    private P payload;

    /**
     * Rest API errors
     */
    private List<ApiError> errors;

    /**
     * Rest API total execution time
     */
    private String executionTime;

    /**
     * Convenient method to create a valid response
     *
     * @param payload Rest API payload
     * @param <T>     Payload type
     * @return Rest API response
     */
    public static <T> ApiResponse<T> ok(final T payload) {
        return ApiResponse.<T>builder()
                .payload(payload)
                .build();
    }

    /**
     * Convenient method to create a response of a single error
     *
     * @param error Rest API error
     * @param <T>   Payload type
     * @return Rest API response
     */
    public static <T> ApiResponse<T> error(final ApiError error) {
        return ApiResponse.<T>builder()
                .errors(List.of(error))
                .build();
    }
}