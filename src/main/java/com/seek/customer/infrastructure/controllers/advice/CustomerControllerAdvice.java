package com.seek.customer.infrastructure.controllers.advice;

import com.seek.customer.domain.exceptions.CustomerMetricExceptionNotFound;
import com.seek.customer.domain.exceptions.CustomerNotFoundException;
import com.seek.customer.domain.exceptions.HandlerNotFoundException;
import com.seek.customer.infrastructure.controllers.advice.dto.ApiError;
import com.seek.customer.domain.exceptions.CustomerDomainException;
import com.seek.customer.infrastructure.controllers.CustomerController;
import com.seek.customer.infrastructure.controllers.advice.dto.ValidationError;
import com.seek.customer.infrastructure.exceptions.CustomerPersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice(assignableTypes = {CustomerController.class})
public class CustomerControllerAdvice {

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ValidationError> validationErrors = exception.getFieldErrors().stream().map(err ->
                new ValidationError(err.getField(), err.getDefaultMessage(), err.getRejectedValue())
        ).toList();

        ApiError apiError = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, "Validation Field", LocalDateTime.now(), validationErrors);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = CustomerDomainException.class)
    public ResponseEntity<ApiError> handlerCustomerDomainException(final CustomerDomainException exception) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = CustomerPersistenceException.class)
    public ResponseEntity<ApiError> handlerCustomerPersistenceException(CustomerPersistenceException exception) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = CustomerMetricExceptionNotFound.class)
    public ResponseEntity<ApiError> handlerCustomerMetricExceptionNotFound(CustomerMetricExceptionNotFound exception) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ApiError> handlerCustomerNotExist(CustomerNotFoundException exception) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = HandlerNotFoundException.class)
    public ResponseEntity<ApiError> handlerQueryHandlerNotFoundException(HandlerNotFoundException exception) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
