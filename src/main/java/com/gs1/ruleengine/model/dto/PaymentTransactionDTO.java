package com.gs1.ruleengine.model.dto;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import lombok.*;

import java.math.BigDecimal;

/**
 * Payment transaction DTO
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionDTO {
    /**
     * Transaction direction [inbound, outbound]
     */
    private PaymentTransaction.Direction direction;

    /**
     * Transaction amount
     */
    private BigDecimal amount;

    /**
     * Transaction amount's currency
     */
    private String currency;

    /**
     * Transaction source account
     */
    private String sourceAccount;

    /**
     * Transaction target account
     */
    private String destinationAccount;
}