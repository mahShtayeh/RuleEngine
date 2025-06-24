package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.model.exception.RecordNotFoundException;
import com.gs1.ruleengine.mapper.BusinessRuleMapper;
import com.gs1.ruleengine.model.dto.BusinessRuleDTO;
import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.repository.BusinessRuleRepository;
import com.gs1.ruleengine.service.BusinessRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business rule services provider
 *
 * @author Mahmoud Shtayeh
 */
@Transactional
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

    /**
     * Read all the business rules service
     *
     * @return List of business rules
     */
    @Override
    @Transactional(readOnly = true)
    public List<BusinessRule> readAll() {
        return businessRuleRepository.findAll();
    }

    /**
     * Read all the business rules service, sorted as passed in
     *
     * @param sort Rules sorter
     * @return List of business rules
     */
    @Override
    @Transactional(readOnly = true)
    public List<BusinessRule> readAllSorted(Sort sort) {
        return businessRuleRepository.findAll(sort);
    }

    /**
     * Read a specific business rule service
     *
     * @return A specific business rule
     */
    @Override
    @Transactional(readOnly = true)
    public BusinessRule read(final Long ruleId) {
        return businessRuleRepository.findById(ruleId)
                .orElseThrow(() -> new RecordNotFoundException("BUSINESS_RULE_NOT_FOUND"));
    }

    /**
     * Update business rule service
     *
     * @param ruleId The business rule to update
     * @param dto    Business rule DTO
     * @return Updated business rule
     */
    @Override
    public BusinessRule update(final Long ruleId, final BusinessRuleDTO dto) {
        final BusinessRule businessRule = businessRuleRepository.findById(ruleId)
                .orElseThrow(() -> new RecordNotFoundException("BUSINESS_RULE_NOT_FOUND"));

        businessRuleMapper.updateEntity(businessRule, dto);
        return businessRuleRepository.save(businessRule);
    }

    /**
     * Delete business rule by ID
     *
     * @param ruleId Business rule ID to delete
     */
    @Override
    public void delete(final Long ruleId) {
        businessRuleRepository.deleteById(ruleId);
    }
}