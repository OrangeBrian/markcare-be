package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.CustomerDTO;
import com.argendev.markcare.models.Customer;
import com.argendev.markcare.services.interfaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<CustomerDTO> getCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(customerService.getUserByUsername(username), HttpStatus.OK);
    }
}
