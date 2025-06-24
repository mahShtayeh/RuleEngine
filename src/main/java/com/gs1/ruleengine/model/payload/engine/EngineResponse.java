package com.gs1.ruleengine.model.payload.engine;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EngineResponse {
    private PaymentTransaction transaction;

    private List<String> appliedRules;

    public Integer getAppliedRulesSize() {
        return this.appliedRules.size();
    }
}