package com.gs1.ruleengine.model.entity;

import jakarta.persistence.*;
import lombok.*;

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
    public enum RuleType {
        ENRICHMENT, ROUTING;
    }
}