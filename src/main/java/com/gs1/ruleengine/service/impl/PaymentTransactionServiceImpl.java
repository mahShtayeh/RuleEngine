package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.repository.PaymentTransactionRepository;
import com.gs1.ruleengine.service.PaymentTransactionService;
import org.springframework.stereotype.Service;

/**
 * Payment transaction services interface
 *
 * @param paymentTransactionRepository
 * @author Mahmoud Shtayeh
 */
@Service("paymentTransactionService")
public record PaymentTransactionServiceImpl(
        PaymentTransactionRepository paymentTransactionRepository
) implements PaymentTransactionService {
}