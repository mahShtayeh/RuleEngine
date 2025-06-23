package com.gs1.ruleengine.model.payload.tranaction;

import lombok.*;

/**
 * Payment transaction creation response
 *
 * @author Mahmoud Shtayeh
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionResponse {
    /**
     * Created transaction ID
     */
    private Long transactionID;
}