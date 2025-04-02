package com.seek.customer.application.Find;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.shared.domain.bus.query.Response;

import java.time.LocalDate;
import java.util.UUID;

public class CustomerResponse implements Response {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public CustomerResponse(UUID id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public static CustomerResponse fromAggregate(Customer customer) {
        return new CustomerResponse(
                customer.id().value(),
                customer.firstName().value(),
                customer.lastName().value(),
                customer.birthDate().value());
    }
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
