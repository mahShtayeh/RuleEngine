package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.repository.BusinessRuleRepository;
import com.gs1.ruleengine.service.BusinessRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Business rule services provider
 *
 * @author Mahmoud Shtayeh
 */
@RequiredArgsConstructor
@Service("businessRuleService")
public class BusinessRuleServiceImpl implements BusinessRuleService {
    /**
     * Business rule repository
     */
    private final BusinessRuleRepository businessRuleRepository;
}