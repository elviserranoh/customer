package com.seek.customer.infrastructure.mappers;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.customer.domain.valueobjects.CustomerBirthDate;
import com.seek.customer.domain.valueobjects.CustomerId;
import com.seek.customer.domain.valueobjects.CustomerFirstName;
import com.seek.customer.domain.valueobjects.CustomerLastName;
import com.seek.customer.infrastructure.persistence.repository.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.id().value())
                .firstName(customer.firstName().value())
                .lastName(customer.lastName().value())
                .birthDate(customer.birthDate().value())
                .build();
    }

    public Customer toAggregate(CustomerEntity entity) {
        CustomerId id = new CustomerId(entity.getId());
        CustomerFirstName firstName = new CustomerFirstName(entity.getFirstName());
        CustomerLastName lastName = new CustomerLastName(entity.getLastName());
        CustomerBirthDate birthDate = new CustomerBirthDate(entity.getBirthDate());
        return Customer.create(id, firstName, lastName, birthDate);
    }

}
