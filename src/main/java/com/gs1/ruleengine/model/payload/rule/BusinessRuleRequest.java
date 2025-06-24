package com.gs1.ruleengine.model.payload.rule;

import com.gs1.ruleengine.model.entity.BusinessRule;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Business rule creation request
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRuleRequest {
    /**
     * Rule's name
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_NAME")
    private String name;

    /**
     * Rule type [ENRICHMENT, ROUTING]
     */
    @NotNull(message = "MISSING_TYPE")
    private BusinessRule.RuleType ruleType;

    /**
     * Rule condition expression
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_CONDITION")
    private String condition;

    /**
     * Rule action expression
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_ACTION")
    private String action;

    /**
     * Rule priority
     */
    @NotNull(message = "MISSING_PRIORITY")
    private Integer priority;

    /**
     * If rule is enabled flag
     */
    @Builder.Default
    private Boolean enabled = true;
}