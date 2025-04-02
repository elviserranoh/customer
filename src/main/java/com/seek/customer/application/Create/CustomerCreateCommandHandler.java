package com.seek.customer.application.Create;

import com.seek.customer.domain.valueobjects.CustomerBirthDate;
import com.seek.customer.domain.valueobjects.CustomerId;
import com.seek.customer.domain.valueobjects.CustomerFirstName;
import com.seek.customer.domain.valueobjects.CustomerLastName;
import com.seek.shared.domain.bus.command.CommandHandler;

public class CustomerCreateCommandHandler implements CommandHandler<CustomerCreateCommand> {

    private final CustomerCreate service;

    public CustomerCreateCommandHandler(CustomerCreate service) {
        this.service = service;
    }

    @Override
    public void handle(CustomerCreateCommand command) {
        CustomerId id = new CustomerId(command.getId());
        CustomerFirstName firstName = new CustomerFirstName(command.getFirstName());
        CustomerLastName lastName = new CustomerLastName(command.getLastName());
        CustomerBirthDate birthDate = new CustomerBirthDate(command.getBirthDate());
        service.create(id, firstName, lastName, birthDate);
    }

    @Override
    public Class<CustomerCreateCommand> getCommandClass() {
        return CustomerCreateCommand.class;
    }
}
