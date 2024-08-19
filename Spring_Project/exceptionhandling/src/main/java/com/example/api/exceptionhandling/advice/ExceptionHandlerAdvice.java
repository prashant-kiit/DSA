package com.example.api.exceptionhandling.advice;

import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleException(ConstraintViolationException exception) {
        Map<String, String> exceptionMap = new HashMap<>();
        exceptionMap.put("Exception_Index", "Message is Hello Hello");
        return exceptionMap;
    }

}
