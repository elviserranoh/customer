package com.seek.customer.application.FindAll;

import com.seek.customer.application.dto.CustomersResponse;
import com.seek.shared.domain.bus.query.QueryHandler;

public class CustomerFindAllQueryHandler implements QueryHandler<CustomerFindAllQuery, CustomersResponse> {

    private CustomerFindAll service;

    public CustomerFindAllQueryHandler(CustomerFindAll service) {
        this.service = service;
    }

    @Override
    public CustomersResponse handle(CustomerFindAllQuery customerFindAllQuery) {
        return service.findAll();
    }

    @Override
    public Class<CustomerFindAllQuery> getQueryClass() {
        return CustomerFindAllQuery.class;
    }
}
