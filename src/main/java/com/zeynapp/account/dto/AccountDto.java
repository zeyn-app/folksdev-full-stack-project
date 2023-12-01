package com.zeynapp.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class AccountDto {
    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto accountCustomerDto;
    private Set<TransactionDto> transactions;
}
