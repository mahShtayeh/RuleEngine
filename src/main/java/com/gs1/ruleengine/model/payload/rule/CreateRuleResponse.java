package com.gs1.ruleengine.model.payload.rule;

import lombok.*;

/**
 * Business rule creation response
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateRuleResponse {
    /**
     * Created business rule ID
     */
    private Long businessRuleID;
}