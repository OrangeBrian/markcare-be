package com.argendev.markcare.services.interfaces;

import com.argendev.markcare.dtos.CustomerDTO;
import com.argendev.markcare.models.Customer;

import java.util.Optional;

public interface CustomerService {
    CustomerDTO save(Customer customer);
    Optional<Customer> getUserById(Long id);
    Optional<Customer> getUserByUsername(String username);
    Optional<Customer> getUserByEmail(String email);
}
