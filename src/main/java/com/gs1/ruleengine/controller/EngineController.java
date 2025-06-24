package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.model.payload.ApiResponse;
import com.gs1.ruleengine.model.payload.engine.EngineResponse;
import com.gs1.ruleengine.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rule engine Rest APIs controller
 *
 * @author Mahmoud Shtayeh
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/engine")
public class EngineController {
    /**
     * Rule engine services provider
     */
    private final EngineService engineService;

    /**
     * Apply all valid rules on the specified transaction
     *
     * @param transactionId Transaction to apply the rules at
     * @return Engine actions summary
     */
    @GetMapping("{transactionId}/updates")
    public ApiResponse<EngineResponse> applyRules(@PathVariable final Long transactionId) {
        return ApiResponse.ok(engineService.applyRules(transactionId));
    }
}