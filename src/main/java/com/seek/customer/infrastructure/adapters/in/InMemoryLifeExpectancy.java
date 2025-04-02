package com.seek.customer.infrastructure.adapters.in;

import com.seek.customer.domain.ports.in.LifeExpectancy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringLifeExpectancy implements LifeExpectancy {

    private final Integer lifeExpectancyYears;

    public SpringLifeExpectancy(@Value("${esperanza.vida.global}") Integer lifeExpectancyYears) {
        this.lifeExpectancyYears = lifeExpectancyYears;
    }

    @Override
    public Integer getLifeExpectancyYears() {
        return lifeExpectancyYears;
    }
}
