package com.seek.customer.infrastructure.persistence.repository;

import com.seek.customer.domain.aggregates.Customer;
import com.seek.customer.infrastructure.persistence.repository.entities.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    @Query(
            value = "SELECT AVG(TIMESTAMPDIFF(YEAR, birth_date, CURDATE())) FROM customers",
            nativeQuery = true
    )
    Optional<Double> findAverageAge();

    @Query(
            value = "SELECT STDDEV_POP(TIMESTAMPDIFF(YEAR, birth_date, CURDATE())) FROM customers",
            nativeQuery = true
    )
    Optional<Double> findStandardDeviationAge();
}
