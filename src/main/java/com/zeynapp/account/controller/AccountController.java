package com.zeynapp.account.controller;

import com.zeynapp.account.dto.AccountDto;
import com.zeynapp.account.dto.CreateAccountRequest;
import com.zeynapp.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest accountRequest){
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }
}
