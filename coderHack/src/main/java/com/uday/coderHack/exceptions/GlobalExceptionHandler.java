package com.uday.coderHack.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

/**
 * GlobalExceptionHandler handles exceptions thrown across the whole application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles ConstraintViolationException exceptions.
     * 
     * @param ex the exception to be handled
     * @return ResponseEntity containing the error message and an HTTP status code
     */

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("Bad Request");
    }
}
