package com.zeynapp.account.dto;

import com.zeynapp.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from){
        return CustomerAccountDto.builder()
                .id(from.getId())
                .balance(from.getBalance())
                .transactions(
                        from.getTransactions().stream().map(converter::convert).collect(Collectors.toSet())
                )
                .creationDate(from.getCreationDate())
                .build();
    }
}
