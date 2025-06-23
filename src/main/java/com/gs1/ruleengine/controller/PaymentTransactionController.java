package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.service.PaymentTransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Payment transactions RestFul APIs
 *
 * @param paymentTransactionService
 * @author Mahmoud Shtayeh
 */
@RestController
@RequestMapping("/api/v1/transactions")
public record PaymentTransactionController(
        PaymentTransactionService paymentTransactionService
) {
}