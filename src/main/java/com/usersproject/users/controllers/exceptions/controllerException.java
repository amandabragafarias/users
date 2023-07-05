package com.usersproject.users.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class controllerException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandler> handler(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();

        List<ErrorHandler> errorList = new ArrayList<>();

        fieldErrorList.forEach(error -> 
        errorList.add(new ErrorHandler(error.getField(), error.getDefaultMessage()))
         );
         return errorList;
    }
}
