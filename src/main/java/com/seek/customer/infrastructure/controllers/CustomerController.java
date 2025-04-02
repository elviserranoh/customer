package com.seek.customer.infrastructure.controllers;
import com.seek.customer.application.Create.CustomerCreateCommand;
import com.seek.customer.application.FindAll.CustomerFindAllQuery;
import com.seek.customer.application.Metric.CustomerMetric;
import com.seek.customer.application.Metric.CustomerMetricQuery;
import com.seek.customer.application.dto.CustomerMetricResponse;
import com.seek.customer.application.dto.CustomerResponse;
import com.seek.customer.application.Find.CustomerFindQuery;
import com.seek.customer.application.dto.CustomersResponse;
import com.seek.shared.domain.bus.command.CommandBus;
import com.seek.shared.domain.bus.query.QueryBus;
import com.seek.shared.infrastructure.spring.ApiController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/customer")
public class CustomerController extends ApiController {

    public CustomerController(CommandBus commandBus, QueryBus queryBus) {
        super(queryBus, commandBus);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        CustomersResponse response = ask(new CustomerFindAllQuery());
        return ResponseEntity.ok().body(response.customers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> get(@PathVariable UUID id) {
        CustomerResponse customer = ask(new CustomerFindQuery(id));
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/metrics")
    public ResponseEntity<CustomerMetricResponse> getMetrics() {
        CustomerMetricResponse metrics = ask(new CustomerMetricQuery());
        return ResponseEntity.ok(metrics);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomerCreateCommand command) {
        dispatch(command);
        return ResponseEntity
                .created(URI.create("/customer/"+command.getId()))
                .build();
    }

}