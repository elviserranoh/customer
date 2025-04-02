package com.seek.customer.domain.exceptions;

public class QueryHandlerNotFoundException extends RuntimeException {
    public QueryHandlerNotFoundException(String message) {
        super(message);
    }
}
