package com.gs1.ruleengine.service;

import com.gs1.ruleengine.model.payload.engine.EngineResponse;

/**
 * Engine services provider
 *
 * @author Mahmoud Shtayeh
 */
public interface EngineService {
    /**
     * Apply the rules' actions based on the conditions
     * to a specific transaction
     *
     * @param transactionId Transaction to apply rules on
     * @return EngineResponse Contains applied rules summary
     */
    EngineResponse applyRules(Long transactionId);
}