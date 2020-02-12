package com.api.pagantis.model.exceptions;

public class HandleExceptionTransaction extends RuntimeException {
    public HandleExceptionTransaction(Exception ex){
        super(ex.getMessage());
    }
}
