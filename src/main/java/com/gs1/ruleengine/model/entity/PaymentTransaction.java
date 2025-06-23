package com.gs1.ruleengine.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

/**
 * Payment Transaction ORM mapped Entity
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentTransaction {
    /**
     * DB generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Transaction direction [inbound, outbound]
     */
    private Direction direction;

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

    /**
     * Transaction possible directions
     *
     * @author Mahmoud Shtayeh
     */
    public enum Direction {
        INBOUND, OUTBOUND
    }
}