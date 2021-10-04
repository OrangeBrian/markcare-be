package com.argendev.markcare.repositories;

import com.argendev.markcare.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);
    Optional<Customer> findCustomerByUsername(String username);
    Optional<Customer> findCustomerByEmail(String email);
}
