package com.zeynapp.account.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Data
@Builder
public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;


}
