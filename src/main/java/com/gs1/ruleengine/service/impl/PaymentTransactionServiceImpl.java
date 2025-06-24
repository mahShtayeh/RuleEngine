package com.gs1.ruleengine.service.impl;

import com.gs1.ruleengine.model.exception.RecordNotFoundException;
import com.gs1.ruleengine.mapper.PaymentTransactionMapper;
import com.gs1.ruleengine.model.dto.PaymentTransactionDTO;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.repository.PaymentTransactionRepository;
import com.gs1.ruleengine.service.PaymentTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * Read payment transaction by ID
     *
     * @param transactionId Transaction ID to read
     * @return Found payment transaction
     */
    @Override
    @Transactional(readOnly = true)
    public PaymentTransaction read(final Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RecordNotFoundException("TRANSACTION_NOT_FOUND"));
    }

    /**
     * Save passed in entity
     *
     * @param paymentTransaction Transaction to save
     */
    @Override
    public void save(final PaymentTransaction paymentTransaction) {
        transactionRepository.save(paymentTransaction);
    }

    /**
     * Delete a specific transaction
     *
     * @param transactionId Transaction to delete
     */
    @Override
    public void delete(final Long transactionId) {
        PaymentTransaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RecordNotFoundException("TRANSACTION_NOT_FOUND"));

        transactionRepository.delete(transaction);
    }
}