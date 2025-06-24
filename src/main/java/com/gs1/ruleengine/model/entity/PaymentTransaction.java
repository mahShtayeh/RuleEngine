package com.gs1.ruleengine.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
public class PaymentTransaction extends Auditable {
    /**
     * DB generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Transaction direction [inbound, outbound]
     */
    @Column(nullable = false)
    private String direction;

    /**
     * Transaction amount
     */
    @Column(nullable = false)
    @Positive(message = "NEGATIVE_AMOUNT")
    private BigDecimal amount;

    /**
     * Transaction amount's currency
     */
    @Column(nullable = false)
    private String currency;

    /**
     * Transaction source account
     */
    @Column(nullable = false)
    private String sourceAccount;

    /**
     * Transaction target account
     */
    @Column(nullable = false)
    private String destinationAccount;

    /**
     * Transaction possible directions
     *
     * @author Mahmoud Shtayeh
     */
    @Getter
    @RequiredArgsConstructor
    public enum Direction {
        INBOUND("inbound"),
        OUTBOUND("outbound");

        /**
         * Direction name
         */
        private final String name;

        /**
         * Represent a direction using its name
         *
         * @return Direction name
         */
        @Override
        public String toString() {
            return this.name;
        }
    }
}