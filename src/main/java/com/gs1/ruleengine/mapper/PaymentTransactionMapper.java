package com.gs1.ruleengine.mapper;

import com.gs1.ruleengine.model.dto.PaymentTransactionDTO;
import com.gs1.ruleengine.model.entity.PaymentTransaction;
import com.gs1.ruleengine.model.payload.tranaction.CreateTransactionRequest;
import org.mapstruct.Mapper;

/**
 * Payment transaction POJOs mapper
 *
 * @author Mahmoud Shtayeh
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper {
    /**
     * Map creation request to DTO
     *
     * @param creationRequest Payment transaction creation request
     * @return Payment transaction DTO
     */
    PaymentTransactionDTO toDTO(CreateTransactionRequest creationRequest);

    /**
     * Map direction name to Enum value
     *
     * @param name Direction name
     * @return Direction Enum
     */
    default PaymentTransaction.Direction toDirection(final String name) {
        return PaymentTransaction.Direction.getByName(name)
                .orElseThrow(() -> new IllegalArgumentException("INVALID_ENUM_VALUE"));
    }

    /**
     * Map payment transaction DTO to an entity
     *
     * @param dto Payment transaction DTO
     * @return Payment transaction Entity
     */
    PaymentTransaction toEntity(PaymentTransactionDTO dto);
}