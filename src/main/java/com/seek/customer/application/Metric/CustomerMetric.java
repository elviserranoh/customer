package com.seek.customer.application.Metric;

import com.seek.customer.application.dto.CustomerMetricResponse;
import com.seek.customer.domain.exceptions.CustomerMetricExceptionNotFound;
import com.seek.customer.domain.ports.out.CustomerRepository;

import java.util.Objects;

public class CustomerMetric {

    private CustomerRepository repository;

    public CustomerMetric(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerMetricResponse calculateStandardDeviationAndAverageAge(CustomerMetricQuery customerMetricQuery) {
        Double average = repository.findAverageAge();
        Double standardDeviation = repository.findStandardDeviationAge();

        if(Objects.isNull(average) || Objects.isNull((standardDeviation))) {
            throw new CustomerMetricExceptionNotFound("No fue posible calcular el promedio y la desviacion estandar por falta de datos");
        }

        return new CustomerMetricResponse(average, standardDeviation);
    }

}
