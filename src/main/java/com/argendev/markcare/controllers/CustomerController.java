package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.CustomerDTO;
import com.argendev.markcare.exceptions.CustomerException;
import com.argendev.markcare.models.Customer;
import com.argendev.markcare.services.interfaces.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper mapper;

    public CustomerController(CustomerService customerService, ModelMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        try {
            Optional<Customer> customerOptional = customerService.getUserByEmail(customer.getEmail());
            if(!customerOptional.isPresent()) {
                return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
            } else {
                throw new CustomerException("CREATE customer failed: email " + customer.getEmail() + " already exists");
            }
        } catch (Exception e) {
            throw new CustomerException("CREATE customer failed: " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDTO) {
        try {
            Optional<Customer> customerOptional = customerService.getUserById(customerDTO.getId());
            if(customerOptional.isPresent()) {
                Customer customer = customerOptional.get();
                customer.setName(customerDTO.getName());
                customer.setLastName(customerDTO.getLastName());
                customer.setCountry(customerDTO.getCountry());
                customer.setCellphone(customerDTO.getCellphone());
                customer.setAddress(customerDTO.getAddress());
                return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
            } else {
                throw new CustomerException("UPDATE customer failed: email " + customerDTO.getEmail() + " doesn't exists");
            }
        } catch (Exception e) {
            throw new CustomerException("UPDATE customer failed: " + e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        try {
            Optional<Customer> customerOptional = customerService.getUserById(id);
            if(customerOptional.isPresent()){
                return new ResponseEntity<>(mapper.map(customerOptional.get(), CustomerDTO.class), HttpStatus.OK);
            } else {
                throw new CustomerException("Customer with id " + id + " not found");
            }
        } catch (Exception e) {
            throw new CustomerException("GET customer by id " + id + " failed: " + e.getMessage());
        }
    }

    @GetMapping("/find/username/{username}")
    public ResponseEntity<CustomerDTO> getCustomerByUsername(@PathVariable String username) {
        try {
            Optional<Customer> customerOptional = customerService.getUserByUsername(username);
            if(customerOptional.isPresent()){
                return new ResponseEntity<>(mapper.map(customerOptional.get(), CustomerDTO.class), HttpStatus.OK);
            } else {
                throw new CustomerException("Customer with username " + username + " not found");
            }
        } catch (Exception e) {
            throw new CustomerException("GET customer by username " + username + " failed: " + e.getMessage());
        }
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        try {
            Optional<Customer> customerOptional = customerService.getUserByEmail(email);
            if(customerOptional.isPresent()){
                return new ResponseEntity<>(mapper.map(customerOptional.get(), CustomerDTO.class), HttpStatus.OK);
            } else {
                throw new CustomerException("Customer with email " + email + " not found");
            }
        } catch (Exception e) {
            throw new CustomerException("GET customer by email " + email + " failed: " + e.getMessage());
        }
    }
}
