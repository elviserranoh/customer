package com.seek.customer.application.Create;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.customer.domain.exceptions.CustomerDomainException;
import com.seek.customer.domain.ports.out.CustomerRepository;
import com.seek.customer.domain.valueobjects.CustomerBirthDate;
import com.seek.customer.domain.valueobjects.CustomerId;
import com.seek.customer.domain.valueobjects.CustomerFirstName;
import com.seek.customer.domain.valueobjects.CustomerLastName;
import com.seek.shared.domain.bus.command.Command;

public class CustomerCreate implements Command {

    private final CustomerRepository repository;

    public CustomerCreate(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(CustomerId id, CustomerFirstName firstName, CustomerLastName lastName, CustomerBirthDate birthDate) {
        Customer customer = Customer.create(id, firstName, lastName, birthDate);
        return repository.create(customer)
                .orElseThrow(() -> new CustomerDomainException("No se puedo almacer el cliente"));
    }
}
