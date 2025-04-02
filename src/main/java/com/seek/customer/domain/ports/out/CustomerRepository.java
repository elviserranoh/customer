package com.seek.customer.domain.ports.out;

import com.seek.customer.domain.aggregates.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> create(Customer customer);
    Optional<Customer> findBy(UUID id);
    List<Customer> findAll();
    Double findAverageAge();
    Double findStandardDeviationAge();
}
