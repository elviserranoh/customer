package com.seek.customer.application.dto;

import com.seek.shared.domain.bus.query.Response;

import java.util.List;

public class CustomersResponse implements Response {
    private final List<CustomerResponse> customers;

    public CustomersResponse(List<CustomerResponse> customers) {
        this.customers = customers;
    }

    public List<CustomerResponse> customers() {
        return customers;
    }
}
