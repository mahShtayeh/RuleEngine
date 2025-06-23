package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.mapper.BusinessRuleMapper;
import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.model.payload.ApiResponse;
import com.gs1.ruleengine.model.payload.rule.CreateRuleRequest;
import com.gs1.ruleengine.model.payload.rule.CreateRuleResponse;
import com.gs1.ruleengine.service.BusinessRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Business rule RestFul APIs
 *
 * @author Mahmoud Shtayeh
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rules")
public class BusinessRuleController {
    /**
     * Business rule services provider
     */
    private final BusinessRuleService businessRuleService;

    /**
     * Business rule POJOs mapper
     */
    private final BusinessRuleMapper businessRuleMapper;

    /**
     * Create business rule
     *
     * @param request Business rule creation request
     * @return Created business rule ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CreateRuleResponse> create(@Valid @RequestBody final CreateRuleRequest request) {
        final BusinessRule businessRule = businessRuleService.create(businessRuleMapper.toDTO(request));
        return ApiResponse.ok(CreateRuleResponse.builder()
                        .businessRuleID(businessRule.getId())
                .build());
    }
}