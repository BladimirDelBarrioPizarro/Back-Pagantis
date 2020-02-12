package com.api.pagantis.model.exceptions;

public class HandleExceptionWalletsByUserName extends RuntimeException {
    public HandleExceptionWalletsByUserName(Exception ex){
        super(ex.getMessage());
    }
}
