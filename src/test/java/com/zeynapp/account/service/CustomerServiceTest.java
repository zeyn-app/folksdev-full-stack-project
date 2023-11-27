package com.zeynapp.account.service;

import com.zeynapp.account.dto.CustomerDto;
import com.zeynapp.account.dto.CustomerDtoConverter;
import com.zeynapp.account.exception.CustomerNotFoundException;
import com.zeynapp.account.model.Customer;
import com.zeynapp.account.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerDtoConverter converter;



    @Test
    void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer serviceCustomer = service.findCustomer("id");

        Assertions.assertEquals(serviceCustomer, customer);
    }

    @Test
    void testFindByCustomerId_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException() {
        String id = "id";
        Mockito.when(customerRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(CustomerNotFoundException.class, () -> service.findCustomer(id));
    }

    @Test
    void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id", "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto resultCustomerDto = service.getCustomerById("id");

        Assertions.assertEquals(resultCustomerDto, customerDto);

    }

    @Test
    void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }

}