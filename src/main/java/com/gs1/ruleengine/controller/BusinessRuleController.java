package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.service.BusinessRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}