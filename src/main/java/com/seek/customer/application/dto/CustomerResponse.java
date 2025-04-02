package com.seek.customer.application.dto;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.shared.domain.bus.query.Response;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class CustomerResponse implements Response {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Integer age;
    private final LocalDate lifeExpectancy;

    public CustomerResponse(UUID id, String firstName, String lastName, LocalDate birthDate, Integer age, LocalDate lifeExpectancy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.lifeExpectancy = lifeExpectancy;
    }

    public static CustomerResponse fromAggregate(Customer customer, Integer lifeExpectancy) {
        return new CustomerResponse(
                customer.id().value(),
                customer.firstName().value(),
                customer.lastName().value(),
                customer.birthDate().value(),
                Period.between(customer.birthDate().value(), LocalDate.now()).getYears(),
                customer.birthDate().value().plusYears(lifeExpectancy)
        );
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

    public Integer getAge() {
        return age;
    }

    public LocalDate getLifeExpectancy() {
        return lifeExpectancy;
    }
}
