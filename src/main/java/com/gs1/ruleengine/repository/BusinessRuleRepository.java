package com.gs1.ruleengine.repository;

import com.gs1.ruleengine.model.entity.BusinessRule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Business rule JPA repository
 *
 * @author Mahmoud Shtayeh
 */
public interface BusinessRuleRepository extends JpaRepository<BusinessRule, Long> {
    /**
     * Retrieve all enabled business rules sorted
     *
     * @param sort Sorting config
     * @return List of sorted-enabled business rules
     */
    List<BusinessRule> findAllByEnabledTrue(Sort sort);
}