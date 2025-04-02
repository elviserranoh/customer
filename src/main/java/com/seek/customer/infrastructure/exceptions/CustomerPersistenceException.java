package com.seek.customer.infrastructure.exceptions;

public class CustomerPersistenceException extends RuntimeException{
    public CustomerPersistenceException(String message) {
        super(message);
    }
}
