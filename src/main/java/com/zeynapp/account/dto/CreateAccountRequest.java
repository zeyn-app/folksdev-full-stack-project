package com.zeynapp.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
    @NotEmpty
    private String customerId;
    @NotBlank
    private BigDecimal initialCredit;
}
