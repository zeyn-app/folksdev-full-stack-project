package com.zeynapp.account.controller;

import com.zeynapp.account.dto.CustomerDto;
import com.zeynapp.account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") String id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
