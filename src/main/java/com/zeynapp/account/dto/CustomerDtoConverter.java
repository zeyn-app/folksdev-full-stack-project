package com.zeynapp.account.dto;

import com.zeynapp.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if(from==null) {
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return CustomerDto.builder()
                .id(from.getId())
                .name(from.getName())
                .surname(from.getSurname())
                .accountDtoSet(from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet()))
                .build();
    }
}
