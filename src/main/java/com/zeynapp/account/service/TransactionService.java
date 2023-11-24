package com.zeynapp.account.service;

import com.zeynapp.account.model.Account;
import com.zeynapp.account.model.Transaction;
import com.zeynapp.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    private Logger logger= LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public Transaction initiateMoney(final Account account, BigDecimal amount) {
        return transactionRepository.save(
                Transaction.builder()
                        .amount(amount)
                        .account(account)
                        .build());
    }
}
