package com.seek.customer.application.Metric;

import com.seek.customer.application.dto.CustomerMetricResponse;
import com.seek.shared.domain.bus.query.QueryHandler;

public class CustomerMetricQueryHandler implements QueryHandler<CustomerMetricQuery, CustomerMetricResponse> {

    private final CustomerMetric service;

    public CustomerMetricQueryHandler(CustomerMetric service) {
        this.service = service;
    }

    @Override
    public CustomerMetricResponse handle(CustomerMetricQuery customerMetricQuery) {
        return service.calculateStandardDeviationAndAverageAge(customerMetricQuery);
    }

    @Override
    public Class<CustomerMetricQuery> getQueryClass() {
        return CustomerMetricQuery.class;
    }
}
