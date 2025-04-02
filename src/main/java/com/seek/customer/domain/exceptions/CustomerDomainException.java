package com.seek.customer.domain.exceptions;

public class CustomerDomainException extends RuntimeException{
    public CustomerDomainException(String message) {
        super(message);
    }
}
