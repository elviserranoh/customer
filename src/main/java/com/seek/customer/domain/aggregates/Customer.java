package com.seek.customer.domain.aggregates;

import com.seek.customer.domain.valueobjects.CustomerBirthDate;
import com.seek.customer.domain.valueobjects.CustomerId;
import com.seek.customer.domain.valueobjects.CustomerName;
import com.seek.shared.domain.aggregate.AggregateRoot;

import java.util.Objects;

public class CustomerAggregate extends AggregateRoot {

    private final CustomerId id;
    private final CustomerName name;
    private final CustomerBirthDate birthDate;

    public CustomerAggregate(CustomerId id, CustomerName name, CustomerBirthDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static CustomerAggregate create(CustomerId id, CustomerName name, CustomerBirthDate birthDate) {
        CustomerAggregate customer = new CustomerAggregate(id, name, birthDate);
        return customer;
    }

    public CustomerId id() {
        return id;
    }

    public CustomerName name() {
        return name;
    }

    public CustomerBirthDate birthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAggregate customer = (CustomerAggregate) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate);
    }
}
