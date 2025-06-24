package com.gs1.ruleengine.model.payload.engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import lombok.*;

import java.util.List;

/**
 * Engine actions summary
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EngineResponse {
    /**
     * Transaction 0 or more rules has been applied at
     */
    private PaymentTransaction transaction;

    /**
     * Applied rules names list
     */
    private List<String> appliedRules;

    /**
     * Total number of applied rules names
     *
     * @return Applied rules names list size
     */
    @JsonProperty("numberOfAppliedRules")
    public Integer getAppliedRulesSize() {
        return this.appliedRules.size();
    }
}