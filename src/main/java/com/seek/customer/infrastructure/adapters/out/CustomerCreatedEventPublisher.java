package com.seek.customer.infrastructure.adapters.out;

import com.seek.customer.domain.events.CustomerCreatedEvent;
import com.seek.customer.domain.ports.out.CustomerCreatedMessagePublisher;
import com.seek.shared.domain.events.DomainEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCreatedEventPublisher implements CustomerCreatedMessagePublisher {

    @Override
    public void publish(List<? extends DomainEvent> list) {
        System.out.println("Ahora mande a Kafka mis eventos " + list.toString());

    }
}
