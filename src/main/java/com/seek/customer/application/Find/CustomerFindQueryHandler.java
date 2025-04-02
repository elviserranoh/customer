package com.seek.customer.application.Find;

import com.seek.customer.application.dto.CustomerResponse;
import com.seek.shared.domain.bus.query.QueryHandler;

public class CustomerFindQueryHandler implements QueryHandler<CustomerFindQuery, CustomerResponse> {

    private final CustomerFind service;

    public CustomerFindQueryHandler(CustomerFind service) {
        this.service = service;
    }

    @Override
    public CustomerResponse handle(CustomerFindQuery customerFindQuery) {
        return service.readBy(customerFindQuery.getId());
    }

    @Override
    public Class<CustomerFindQuery> getQueryClass() {
        return CustomerFindQuery.class;
    }
}
