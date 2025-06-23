package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.mapper.BusinessRuleMapper;
import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.model.payload.ApiResponse;
import com.gs1.ruleengine.model.payload.rule.BusinessRuleRequest;
import com.gs1.ruleengine.model.payload.rule.CreateRuleResponse;
import com.gs1.ruleengine.service.BusinessRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * Create business rule API
     *
     * @param request Business rule creation request
     * @return Created business rule ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CreateRuleResponse> create(@Valid @RequestBody final BusinessRuleRequest request) {
        final BusinessRule businessRule = businessRuleService.create(businessRuleMapper.toDTO(request));
        return ApiResponse.ok(CreateRuleResponse.builder()
                .businessRuleID(businessRule.getId())
                .build());
    }

    /**
     * Read a specific business rule API
     *
     * @return The specified business rule
     */
    @GetMapping("{ruleId}")
    public ApiResponse<BusinessRule> read(@PathVariable final Long ruleId) {
        return ApiResponse.ok(businessRuleService.read(ruleId));
    }

    /**
     * Read all the business rules API
     *
     * @return List of business rules
     */
    @GetMapping
    public ApiResponse<List<BusinessRule>> readAll() {
        return ApiResponse.ok(businessRuleService.readAll());
    }

    /**
     * Update specific business rule
     *
     * @param ruleId The business rule to update
     * @param request Business rule update request
     * @return Updated business rule
     */
    @PutMapping("{ruleId}")
    public ApiResponse<BusinessRule> update(@PathVariable final Long ruleId,
                                            @Valid @RequestBody final BusinessRuleRequest request) {
        return ApiResponse.ok(businessRuleService.update(ruleId, businessRuleMapper.toDTO(request)));
    }
}