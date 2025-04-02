package com.seek.customer.domain.ports.out;

import com.seek.customer.domain.events.CustomerCreatedEvent;
import com.seek.shared.domain.events.DomainEventPublisher;

public interface CustomerCreatedDomainEventPublisher extends DomainEventPublisher<CustomerCreatedEvent> {
}
