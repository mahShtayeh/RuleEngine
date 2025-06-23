package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.mapper.BusinessRuleMapper;
import com.gs1.ruleengine.model.dto.BusinessRuleDTO;
import com.gs1.ruleengine.model.entity.BusinessRule;
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

    /**
     * Business rule POJOs mapper
     */
    private final BusinessRuleMapper businessRuleMapper;

    /**
     * Create business rule
     *
     * @param dto Business rule DTO
     * @return Business rule entity
     */
    @Override
    public BusinessRule create(final BusinessRuleDTO dto) {
        return businessRuleRepository.save(businessRuleMapper.toEntity(dto));
    }
}