package com.seek.customer.domain.exceptions;

public class CustomerNotExist extends RuntimeException{
    public CustomerNotExist(String message) {
        super(message);
    }
}
