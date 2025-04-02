package com.seek.customer.infrastructure.adapters.out;

import com.seek.shared.domain.events.DomainEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCreatedEvenPublisher implements DomainEventPublisher
{
    @Override
    public void publish(List<DomainEvent> domainEvents) {
        System.out.println("Ahora mande a Kafka mis eventos " + domainEvents.toString());
    }
}
