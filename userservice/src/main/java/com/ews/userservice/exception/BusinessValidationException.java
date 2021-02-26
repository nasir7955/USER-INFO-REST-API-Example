package com.ews.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BusinessValidationException extends RuntimeException{

    public BusinessValidationException() {


    }

    @ExceptionHandler (value = {BusinessValidationException.class})
    protected ResponseEntity<Object> handleException(BusinessValidationException bve, WebRequest wr){

        //Todo: thru appropriate business exception message, status...etc
        final ResponseEntity<Object> tResponseEntity = new ResponseEntity<Object>(bve, HttpStatus.BAD_REQUEST);
        return tResponseEntity;

    }

}
