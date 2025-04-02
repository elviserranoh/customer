package com.seek.customer.application.FindAll;

import com.seek.customer.application.dto.CustomerResponse;
import com.seek.customer.application.dto.CustomersResponse;
import com.seek.customer.domain.ports.in.LifeExpectancy;
import com.seek.customer.domain.ports.out.CustomerRepository;

public class CustomerFindAll {
    private final CustomerRepository repository;
    private final LifeExpectancy lifeExpectancy;

    public CustomerFindAll(CustomerRepository repository, LifeExpectancy lifeExpectancy) {
        this.repository = repository;
        this.lifeExpectancy = lifeExpectancy;
    }

    public CustomersResponse findAll() {
        return new CustomersResponse(
                repository.findAll().stream().map(c -> CustomerResponse.fromAggregate(c, lifeExpectancy.getLifeExpectancyYears())).toList()
        );
    }

}
