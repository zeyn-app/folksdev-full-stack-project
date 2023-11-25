package com.zeynapp.account;

import com.zeynapp.account.model.Customer;
import com.zeynapp.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String...args){
		Customer customer = customerRepository.save(Customer
				.builder()
				.name("Zeynep")
				.surname("Özdemir")
				.build());
		System.out.println(customer);
	}
}
