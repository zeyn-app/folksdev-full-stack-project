package com.zeynapp.account.service;

import com.zeynapp.account.dto.AccountDto;
import com.zeynapp.account.dto.AccountDtoConverter;
import com.zeynapp.account.dto.CreateAccountRequest;
import com.zeynapp.account.model.Account;
import com.zeynapp.account.model.Customer;
import com.zeynapp.account.model.Transaction;
import com.zeynapp.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest accountRequest) {
        String customerId = accountRequest.getCustomerId();
        Customer customer = customerService.findCustomer(customerId);

        Account account = Account.builder().customer(customer)
                .creationDate(LocalDateTime.now())
                .balance(accountRequest.getInitialCredit())
                .build();


        if (accountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = Transaction.builder()
                    .account(account)
                    .amount(accountRequest.getInitialCredit())
                    .build();

            account.getTransactions().add(transaction);
        }
        return converter.convertToAccount(accountRepository.save(account));
    }
}
