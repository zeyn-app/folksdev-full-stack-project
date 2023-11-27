package com.zeynapp.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
    @NotEmpty
    private String customerId;
    @Min(0)
    private BigDecimal initialCredit;
}
