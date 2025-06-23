package com.gs1.ruleengine.service;

import com.gs1.ruleengine.model.dto.BusinessRuleDTO;
import com.gs1.ruleengine.model.entity.BusinessRule;

import java.util.List;

/**
 * Business rule services provider
 *
 * @author Mahmoud Shtayeh
 */
public interface BusinessRuleService {
    /**
     * Create business rule
     *
     * @param dto Business rule DTO
     * @return Business rule entity
     */
    BusinessRule create(BusinessRuleDTO dto);

    /**
     * Read all the business rules service
     *
     * @return List of business rules
     */
    List<BusinessRule> readAll();

    /**
     * Read a specific business rule service
     *
     * @return A specific business rule
     */
    BusinessRule read(Long ruleId);

    /**
     * Update business rule service
     *
     * @param ruleId The business rule to update
     * @param dto    Business rule DTO
     * @return Updated business rule
     */
    BusinessRule update(Long ruleId, BusinessRuleDTO dto);

    /**
     * Delete business rule by ID
     *
     * @param ruleId Business rule ID to delete
     */
    void delete(Long ruleId);
}