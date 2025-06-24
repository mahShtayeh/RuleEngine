package com.gs1.ruleengine.model.dto;

import com.gs1.ruleengine.model.entity.BusinessRule;
import lombok.*;

/**
 * Business rule DTO
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRuleDTO {
    /**
     * Rule's name
     */
    private String name;

    /**
     * Rule type [ENRICHMENT, ROUTING]
     */
    private BusinessRule.RuleType ruleType;

    /**
     * Rule condition expression
     */
    private String condition;

    /**
     * Rule action expression
     */
    private String action;

    /**
     * Rule priority
     */
    private Integer priority;

    /**
     * If rule is enabled flag
     */
    private Boolean enabled;
}