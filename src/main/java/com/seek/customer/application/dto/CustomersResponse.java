package com.seek.customer.application.FindAll;

import com.seek.customer.application.Find.CustomerResponse;
import com.seek.customer.domain.aggregates.Customer;
import com.seek.shared.domain.bus.query.Response;

import java.util.List;

public class CustomersResponse implements Response {
    private final List<CustomerResponse> customers;

    public CustomersResponse(List<CustomerResponse> customers) {
        this.customers = customers;
    }

    public static CustomerResponse fromAggregate(List<Customer> customers) {
        return new CustomersResponse(customers.stream().map(customer -> CustomerResponse.fromAggregate(customer)).toList());
    }
    public List<CustomerResponse> getCustomers() {
        return customers;
    }
}
