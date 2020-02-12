package com.api.pagantis.model.exceptions;

public class HandleExceptionWalletsByUserId extends RuntimeException {
    public HandleExceptionWalletsByUserId(Exception ex){
        super(ex.getMessage());
    }
}
