package com.gs1.ruleengine.repository;

import com.gs1.ruleengine.model.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Payment transaction JPA repository
 *
 * @author Mahmoud Shtayeh
 */
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
}