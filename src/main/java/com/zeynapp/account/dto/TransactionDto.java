package com.zeynapp.account.dto;

import com.zeynapp.account.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class TransactionDto {
    private String id;
    @Builder.Default
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
