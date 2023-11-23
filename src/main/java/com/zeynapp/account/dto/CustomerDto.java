package com.zeynapp.account.dto;

import lombok.Data;

import java.util.Set;
@Data
public class CustomerDto {
    private String id;
    private String name;
    private String surname;
    private Set<AccountDto> accountDtoSet;
}
