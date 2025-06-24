package com.gs1.ruleengine.mapper;

import com.gs1.ruleengine.model.dto.BusinessRuleDTO;
import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.model.payload.rule.BusinessRuleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Business rule POJOs mapper
 *
 * @author Mahmoud Shtayeh
 */
@Mapper(componentModel = "spring")
public interface BusinessRuleMapper {
    /**
     * Map creation request to DTO
     *
     * @param request Business rule request
     * @return Business rule DTO
     */
    BusinessRuleDTO toDTO(BusinessRuleRequest request);

    /**
     * Map business rule DTO to entity
     *
     * @param dto Business rule DTO
     * @return Business rule entity
     */
    BusinessRule toEntity(BusinessRuleDTO dto);

    /**
     * Update passed in business rule by the DTO attributes
     *
     * @param businessRule Target business rule
     * @param dto          Business rule DTO holding the properties
     */
    void updateEntity(@MappingTarget BusinessRule businessRule, BusinessRuleDTO dto);
}