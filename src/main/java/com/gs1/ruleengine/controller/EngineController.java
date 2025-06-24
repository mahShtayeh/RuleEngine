package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.model.payload.ApiResponse;
import com.gs1.ruleengine.model.payload.engine.EngineResponse;
import com.gs1.ruleengine.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/engine")
public class EngineController {
    private final EngineService engineService;

    @GetMapping("{transactionId}/updates")
    public ApiResponse<EngineResponse> applyRules(@PathVariable final Long transactionId) {
        return ApiResponse.ok(engineService.applyRules(transactionId));
    }
}