package com.api.pagantis.model.exceptions.messages;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    ERROR_TRANSACTION(101,"Entities have denied the transaction, perhaps due to a network error"),
    ERROR_GET_USERS(102,"A Runtime or network connection error has occurred"),
    ERROR_WALLETS_BY_USERID(103,"Surely there was an error getting parameters"),
    ERROR_WALLETS_BY_USERNAME(104,"Surely there was an error getting parameters");
    private Integer code;
    private String message;

    ErrorMessages(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
