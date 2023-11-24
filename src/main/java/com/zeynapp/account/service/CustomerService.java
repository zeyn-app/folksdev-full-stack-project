package com.zeynapp.account.service;

import com.zeynapp.account.exception.CustomerNotFoundException;
import com.zeynapp.account.model.Customer;
import com.zeynapp.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomer(String id){
        return customerRepository.findById(id).orElseThrow(
                ()-> new CustomerNotFoundException("Customer could not found by id: " + id));
    }
}
