package com.zeynapp.account.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
@Data
@Builder
public class CustomerDto {
    private String id;
    private String name;
    private String surname;
    private Set<CustomerAccountDto> accountDtoSet;
}
