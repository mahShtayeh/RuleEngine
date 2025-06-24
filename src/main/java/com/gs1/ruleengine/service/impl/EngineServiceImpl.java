package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.model.entity.BusinessRule;
import com.gs1.ruleengine.model.entity.BusinessRule_;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.model.payload.engine.EngineResponse;
import com.gs1.ruleengine.service.BusinessRuleService;
import com.gs1.ruleengine.service.EngineService;
import com.gs1.ruleengine.service.PaymentTransactionService;
import com.gs1.ruleengine.util.RuleEngineUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Engine services provider
 *
 * @author Mahmoud Shtayeh
 */
@Service("engineService")
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {
    /**
     * Business rules services provider
     */
    private final BusinessRuleService businessRuleService;

    /**
     * Payment transactions services provider
     */
    private final PaymentTransactionService paymentTransactionService;

    /**
     * Apply the rules' actions based on the conditions
     * to a specific transaction
     *
     * @param transactionId Transaction to apply rules on
     * @return EngineResponse Contains applied rules summary
     */
    @Override
    public EngineResponse applyRules(final Long transactionId) {
        final PaymentTransaction transaction = paymentTransactionService.read(transactionId);

        final Map<BusinessRule.RuleType, List<BusinessRule>> rulesMap = businessRuleService
                .readAllEnabledSorted(Sort.by(BusinessRule_.PRIORITY).descending())
                .stream()
                .collect(Collectors.groupingBy(BusinessRule::getRuleType));

        final List<String> appliedRulesNames = new ArrayList<>();
        if (rulesMap.containsKey(BusinessRule.RuleType.ROUTING)) {
            rulesMap.get(BusinessRule.RuleType.ROUTING).stream()
                    .filter(businessRule -> RuleEngineUtil.evaluateCondition(transaction, businessRule.getCondition()))
                    .findFirst()
                    .ifPresent(businessRule -> {
                        RuleEngineUtil.applyAction(transaction, businessRule.getAction());
                        appliedRulesNames.add(businessRule.getName());
                    });
        }

        if (rulesMap.containsKey(BusinessRule.RuleType.ENRICHMENT)) {
            rulesMap.get(BusinessRule.RuleType.ENRICHMENT).stream()
                    .filter(businessRule -> RuleEngineUtil.evaluateCondition(transaction, businessRule.getCondition()))
                    .forEach(businessRule -> {
                        RuleEngineUtil.applyAction(transaction, businessRule.getAction());
                        appliedRulesNames.add(businessRule.getName());
                    });
        }

        if (!appliedRulesNames.isEmpty()) {
            paymentTransactionService.save(transaction);
        }
        return EngineResponse.builder()
                .transaction(transaction)
                .appliedRules(appliedRulesNames)
                .build();
    }
}