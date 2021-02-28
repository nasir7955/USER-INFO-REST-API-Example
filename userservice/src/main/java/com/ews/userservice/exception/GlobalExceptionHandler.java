package com.ews.userservice.exception;

import com.ews.userservice.model_pojos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private ErrorResponse errorResponse;
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<Object> handleException(Throwable t, WebRequest wr){
        errorResponse = new ErrorResponse();
        errorResponse.setErrMessage(t.getMessage());
        errorResponse.setErrMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ResponseBody
    @ExceptionHandler(BusinessValidationException.class)
    protected ResponseEntity<Object> handleBusinessException(Throwable t, WebRequest wr){
        errorResponse = new ErrorResponse();
        errorResponse.setErrMessage(t.getMessage());
        errorResponse.setErrMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return new ResponseEntity<Object>(t, HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(Throwable t, WebRequest wr){

        //construct error and send generic error response json message todo
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setErrMessage(t.getMessage());

        return new ResponseEntity<Object>(t, HttpStatus.BAD_REQUEST);

    }


}
