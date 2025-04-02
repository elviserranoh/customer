package com.seek.customer.infrastructure.persistence;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.customer.domain.ports.out.CustomerRepository;
import com.seek.customer.infrastructure.exceptions.CustomerPersistenceException;
import com.seek.customer.infrastructure.mappers.CustomerMapper;
import com.seek.customer.infrastructure.persistence.repository.CustomerJpaRepository;
import com.seek.customer.infrastructure.persistence.repository.entities.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class MySqlCustomerRepository implements CustomerRepository {

    private final CustomerJpaRepository repository;
    private final CustomerMapper mapper;

    public MySqlCustomerRepository(CustomerJpaRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Customer> create(Customer customer) {
        CustomerEntity result = null;
        try {
            result = repository.save(mapper.toEntity(customer));
        } catch (DataAccessException exception) {
            log.error("Error en repository save: {}", exception);
            throw new CustomerPersistenceException(exception.getMessage());
        }
        return Optional.ofNullable(result).map(mapper::toAggregate);
    }

    @Override
    public Optional<Customer> findBy(UUID id) {
        Optional<CustomerEntity> customer = repository.findById(id);
        return customer.map(mapper::toAggregate);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll().stream().map(mapper::toAggregate).toList();
    }

    @Override
    public Double findAverageAge() {
        return repository.findAverageAge().orElse(0.0d);
    }

    @Override
    public Double findStandardDeviationAge() {
        return repository.findStandardDeviationAge().orElse(0.0d);
    }
}
