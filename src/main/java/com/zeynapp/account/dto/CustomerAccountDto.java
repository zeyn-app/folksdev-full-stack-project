package com.zeynapp.account.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class CustomerAccountDto {
    private String id;
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<TransactionDto> transactionDtoSet;
    private LocalDateTime creationDate;


}
