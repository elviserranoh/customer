package com.seek.customer.infrastructure.controllers.advice.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private final String message;
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final List<ValidationError> validationErrors;

    public ApiError(HttpStatus status, String message, LocalDateTime timestamp, List<ValidationError> validationErrors) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.validationErrors = validationErrors;
    }

    public ApiError(HttpStatus status, String message, LocalDateTime timestamp) {
        this(status, message, timestamp,null);
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
