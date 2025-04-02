package com.seek.customer.domain.aggregates;

import com.seek.customer.domain.events.CustomerCreatedEvent;
import com.seek.customer.domain.valueobjects.CustomerBirthDate;
import com.seek.customer.domain.valueobjects.CustomerId;
import com.seek.customer.domain.valueobjects.CustomerFirstName;
import com.seek.customer.domain.valueobjects.CustomerLastName;
import com.seek.shared.domain.aggregate.AggregateRoot;

import java.util.Objects;

public class Customer extends AggregateRoot {

    private final CustomerId id;
    private final CustomerFirstName firstName;
    private final CustomerLastName lastName;
    private final CustomerBirthDate birthDate;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Customer create(CustomerId id, CustomerFirstName firstName, CustomerLastName lastName, CustomerBirthDate birthDate) {
        Customer customer = builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();

        customer.record(
                new CustomerCreatedEvent(id.value(),
                        firstName.value(),
                        lastName.value(),
                        birthDate.value()
                )
        );

        return customer;
    }

    public CustomerId id() {
        return id;
    }

    public CustomerFirstName firstName() {
        return firstName;
    }

    public CustomerLastName lastName() {
        return lastName;
    }

    public CustomerBirthDate birthDate() {
        return birthDate;
    }

    public static class Builder {
        private CustomerId id;
        private CustomerFirstName firstName;
        private CustomerLastName lastName;
        private CustomerBirthDate birthDate;

        public Builder id(CustomerId id) {
            this.id = id;
            return this;
        }

        public Builder firstName(CustomerFirstName firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(CustomerLastName lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDate(CustomerBirthDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, birthDate);
    }
}
