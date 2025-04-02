package com.seek.customer.application.Find;

import com.seek.shared.domain.bus.query.Query;

import java.util.UUID;

public class FindCustomerQuery implements Query {
    private final UUID id;

    public FindCustomerQuery(UUID id) {
        this.id = id;
    }
}
