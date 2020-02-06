package com.api.pagantis.model.exceptions;

public class HandleExceptionGetUsers extends RuntimeException {

    public HandleExceptionGetUsers(Exception ex){
        super(ex.getMessage());
    }
}
