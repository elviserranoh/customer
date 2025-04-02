package com.seek.customer.domain.events;

import com.seek.shared.domain.events.DomainEvent;

import java.time.LocalDate;
import java.util.UUID;

public final class CustomerCreatedEvent extends DomainEvent {
    private final UUID customerId;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public CustomerCreatedEvent(UUID customerId, String firstName, String lastName, LocalDate birthDate) {
        super();
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public UUID getCustomerId() {
        return customerId;
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
