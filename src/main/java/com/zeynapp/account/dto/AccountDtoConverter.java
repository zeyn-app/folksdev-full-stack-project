package com.zeynapp.account.dto;

import com.zeynapp.account.model.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;


    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }


    public AccountDto convertToAccount(Account from){
        Set<TransactionDto> transactionDtoSet = Objects.requireNonNull(from.getTransactions())
                .stream()
                .map(transactionDtoConverter::convert)
                .collect(Collectors.toSet());

//        return new AccountDto(from.getId());

        return new AccountDto(from.getId(), from.getBalance(),
                from.getCreationDate(), customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
                transactionDtoSet);
    }
}
