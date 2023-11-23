package com.zeynapp.account.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactionDtoSet;
    private LocalDateTime creationDate;


}