package com.gs1.ruleengine.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Direction direction;

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
         * Directions name - Enum map
         */
        private static final Map<String, Direction> LOOKUP = new HashMap<>();

        /**
         * Direction name
         */
        private final String name;

        static {
            for (final Direction direction : values()) {
                LOOKUP.put(direction.getName(), direction);
            }
        }

        /**
         * Map Direction based on the passed name
         *
         * @param name Direction name
         * @return Direction Enum
         */
        public static Optional<Direction> getByName(final String name) {
            return Optional.ofNullable(LOOKUP.get(name));
        }

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