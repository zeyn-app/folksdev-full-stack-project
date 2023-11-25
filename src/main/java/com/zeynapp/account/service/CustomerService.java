package com.zeynapp.account.service;

import com.zeynapp.account.dto.CustomerDto;
import com.zeynapp.account.dto.CustomerDtoConverter;
import com.zeynapp.account.exception.CustomerNotFoundException;
import com.zeynapp.account.model.Customer;
import com.zeynapp.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomer(String id){
        return customerRepository.findById(id).orElseThrow(
                ()-> new CustomerNotFoundException("Customer could not found by id: " + id));
    }


    public CustomerDto getCustomerById(String id) {
        return converter.convertToCustomerDto(findCustomer(id));
    }
}
