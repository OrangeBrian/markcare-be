package com.argendev.markcare.services.interfaces;

import com.argendev.markcare.dtos.CustomerDTO;
import com.argendev.markcare.models.Customer;

public interface CustomerService {
    CustomerDTO save(Customer customer);
    CustomerDTO getUserById(Long id);
}
