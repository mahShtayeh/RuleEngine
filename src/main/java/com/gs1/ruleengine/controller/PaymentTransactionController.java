package com.gs1.ruleengine.controller;

import com.gs1.ruleengine.mapper.PaymentTransactionMapper;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.model.payload.ApiResponse;
import com.gs1.ruleengine.model.payload.tranaction.CreateTransactionRequest;
import com.gs1.ruleengine.model.payload.tranaction.CreateTransactionResponse;
import com.gs1.ruleengine.service.PaymentTransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Payment transactions RestFul APIs
 *
 * @author Mahmoud Shtayeh
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class PaymentTransactionController {
    /**
     * Payment transaction services provider
     */
    private final PaymentTransactionService transactionService;

    /**
     * Payment transaction POJOs mapper
     */
    private final PaymentTransactionMapper transactionMapper;

    /**
     * Create payment transaction API
     *
     * @param request Payment transaction creation API
     * @return Created transaction ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CreateTransactionResponse> create(@Valid @RequestBody final CreateTransactionRequest request) {
        final PaymentTransaction transaction = transactionService.create(transactionMapper.toDTO(request));
        return ApiResponse.ok(CreateTransactionResponse.builder()
                .transactionId(transaction.getId())
                .build());
    }

    /**
     * Delete a specific payment transaction
     *
     * @param transactionId Transaction to delete
     */
    @DeleteMapping("{transactionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long transactionId) {
        transactionService.delete(transactionId);
    }
}