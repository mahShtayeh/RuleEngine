package com.gs1.ruleengine.mapper;

import com.gs1.ruleengine.model.dto.BusinessRuleDTO;
import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.model.payload.rule.CreateRuleRequest;
import org.mapstruct.Mapper;

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
    BusinessRuleDTO toDTO(CreateRuleRequest request);

    /**
     * Map rule type name to Enum value
     *
     * @param ruleName Rule type name
     * @return Rule type Enum
     */
    default BusinessRule.RuleType toRuleType(final String ruleName) {
        return BusinessRule.RuleType.getByName(ruleName)
                .orElseThrow(() -> new IllegalArgumentException("INVALID_ENUM_VALUE"));
    }

    /**
     * Map business rule DTO to entity
     *
     * @param dto Business rule DTO
     * @return Business rule entity
     */
    BusinessRule toEntity(BusinessRuleDTO dto);
}