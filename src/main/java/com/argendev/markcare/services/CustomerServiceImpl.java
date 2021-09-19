package com.argendev.markcare.services;

import com.argendev.markcare.dtos.CustomerDTO;
import com.argendev.markcare.models.Customer;
import com.argendev.markcare.repositories.CustomerRepository;
import com.argendev.markcare.services.interfaces.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO save(Customer customer) {
        return mapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    @Override
    public CustomerDTO getUserById(Long id) {
        return mapper.map(customerRepository.findCustomerById(id), CustomerDTO.class);
    }


}
