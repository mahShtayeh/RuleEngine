package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.mapper.PaymentTransactionMapper;
import com.gs1.ruleengine.model.dto.PaymentTransactionDTO;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.repository.PaymentTransactionRepository;
import com.gs1.ruleengine.service.PaymentTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Payment transaction services interface
 *
 * @author Mahmoud Shtayeh
 */
@Transactional
@RequiredArgsConstructor
@Service("paymentTransactionService")
public class PaymentTransactionServiceImpl implements PaymentTransactionService {
    /**
     * Payment transaction repository
     */
    private final PaymentTransactionRepository transactionRepository;

    /**
     * Payment transaction POJOs mapper
     */
    private final PaymentTransactionMapper transactionMapper;

    /**
     * Payment transaction creation service
     *
     * @param dto Payment transaction DTO
     * @return Created payment transaction entity
     */
    @Override
    public PaymentTransaction create(final PaymentTransactionDTO dto) {
        return transactionRepository.save(transactionMapper.toEntity(dto));
    }
}