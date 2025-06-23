package com.gs1.ruleengine.service;

import com.gs1.ruleengine.model.dto.PaymentTransactionDTO;
import com.gs1.ruleengine.model.entity.PaymentTransaction;

/**
 * Payment transaction services interface
 *
 * @author Mahmoud Shtayeh
 */
public interface PaymentTransactionService {
    /**
     * Payment transaction creation service
     *
     * @param dto Payment transaction DTO
     * @return Created payment transaction entity
     */
    PaymentTransaction create(PaymentTransactionDTO dto);

    /**
     * Delete a specific transaction
     *
     * @param transactionId Transaction to delete
     */
    void delete(Long transactionId);
}