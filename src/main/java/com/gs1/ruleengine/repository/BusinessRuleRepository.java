package com.gs1.ruleengine.repository;

import com.gs1.ruleengine.model.entity.BusinessRule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Business rule JPA repository
 *
 * @author Mahmoud Shtayeh
 */
public interface BusinessRuleRepository extends JpaRepository<BusinessRule, Long> {
}