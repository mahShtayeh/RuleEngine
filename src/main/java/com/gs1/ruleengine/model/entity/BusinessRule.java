package com.gs1.ruleengine.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Business Rule Entity
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BusinessRule {
    /**
     * DB generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Rule's name
     */
    @Column(nullable = false)
    private String name;

    /**
     * Rule type [ENRICHMENT, ROUTING]
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RuleType ruleType;

    /**
     * Rule condition expression
     */
    @Column(nullable = false)
    private String condition;

    /**
     * Rule action expression
     */
    @Column(nullable = false)
    private String action;

    /**
     * Rule priority
     */
    private Integer priority;

    /**
     * Possible rule types
     *
     * @author Mahmoud Shtayeh
     */
    @Getter
    @RequiredArgsConstructor
    public enum RuleType {
        ENRICHMENT("Enrichment"),
        ROUTING("Routing");

        /**
         * Rule type name - Enum map
         */
        private static final Map<String, RuleType> LOOKUP = new HashMap<>();

        /**
         * Rule type name
         */
        private final String name;

        static {
            for (final RuleType ruleType : values()) {
                LOOKUP.put(ruleType.getName(), ruleType);
            }
        }

        /**
         * Map Rule type based on the passed name
         *
         * @param ruleName Rule type name
         * @return Rule type Enum
         */
        public static Optional<RuleType> getByName(final String ruleName) {
            return Optional.ofNullable(LOOKUP.get(ruleName));
        }

        /**
         * Represent a rule type using its name
         *
         * @return Rule type name
         */
        @Override
        public String toString() {
            return this.name;
        }
    }
}