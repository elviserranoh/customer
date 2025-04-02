package com.seek.customer.application.Find;

import com.seek.customer.application.dto.CustomerResponse;
import com.seek.customer.domain.exceptions.CustomerNotFoundException;
import com.seek.customer.domain.ports.in.LifeExpectancy;
import com.seek.customer.domain.ports.out.CustomerRepository;

import java.util.UUID;

public class CustomerFind {

    private final CustomerRepository repository;
    private final LifeExpectancy lifeExpectancy;

    public CustomerFind(CustomerRepository repository,LifeExpectancy lifeExpectancy) {
        this.repository = repository;
        this.lifeExpectancy = lifeExpectancy;
    }

    public CustomerResponse readBy(UUID id) {
        return repository.findBy(id)
                .map(c -> CustomerResponse.fromAggregate(c, lifeExpectancy.getLifeExpectancyYears()))
                .orElseThrow(() ->
                        new CustomerNotFoundException("Curso no existe " + id)
                );
    }

}
