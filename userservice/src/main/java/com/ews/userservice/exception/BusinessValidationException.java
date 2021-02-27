package com.ews.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BusinessValidationException extends RuntimeException{

    public BusinessValidationException() {

        //Todo: exception handling


    }

}
