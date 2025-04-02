package com.seek.customer.application.dto;

import com.seek.shared.domain.bus.query.Response;

public class CustomerMetricResponse implements Response {
    private final Double averageAge;
    private final Double standardDeviationAge;

    public CustomerMetricResponse(Double averageAge, Double standardDeviationAge) {
        this.averageAge = averageAge;
        this.standardDeviationAge = standardDeviationAge;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public Double getStandardDeviationAge() {
        return standardDeviationAge;
    }
}
