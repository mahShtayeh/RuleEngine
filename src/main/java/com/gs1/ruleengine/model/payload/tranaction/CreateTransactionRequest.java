package com.gs1.ruleengine.model.payload.tranaction;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.validator.annotation.EnumValue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

/**
 * Payment transaction creation request
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {
    /**
     * Transaction direction [inbound, outbound]
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_DIRECTION")
    @EnumValue(enumClass = PaymentTransaction.Direction.class, message = "INVALID_ENUM_VALUE")
    private String direction;

    /**
     * Transaction amount
     */
    @NotNull(message = "MISSING_AMOUNT")
    @Positive(message = "INVALID_AMOUNT")
    private BigDecimal amount;

    /**
     * Transaction amount's currency
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_CURRENCY")
    private String currency;

    /**
     * Transaction source account
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_SOURCE_ACCOUNT")
    private String sourceAccount;

    /**
     * Transaction target account
     */
    @NotEmpty(message = "MISSING_OR_EMPTY_DESTINATION_ACCOUNT")
    private String destinationAccount;
}