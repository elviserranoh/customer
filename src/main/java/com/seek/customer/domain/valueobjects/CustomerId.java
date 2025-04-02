package com.seek.customer.domain.valueobjects;

import com.seek.shared.domain.valueobject.Identifier;

import java.util.UUID;

public class CustomerId extends Identifier {
    public CustomerId(UUID value) {
        super(value);
    }
}
