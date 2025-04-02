package com.seek.customer.domain.valueobjects;

import com.seek.shared.domain.valueobject.DateValueObject;
import java.time.LocalDate;

public class CustomerBirthDate extends DateValueObject {
    public CustomerBirthDate(LocalDate value) {
        super(value);
    }
}
