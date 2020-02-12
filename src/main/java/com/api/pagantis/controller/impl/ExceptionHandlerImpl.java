package com.api.pagantis.controller.impl;

import com.api.pagantis.model.dto.HttpErrorDTO;
import com.api.pagantis.model.exceptions.HandleExceptionGetUsers;
import com.api.pagantis.model.exceptions.HandleExceptionTransaction;
import com.api.pagantis.model.exceptions.HandleExceptionWalletsByUserId;
import com.api.pagantis.model.exceptions.HandleExceptionWalletsByUserName;
import com.api.pagantis.model.exceptions.messages.ErrorMessages;
import com.api.pagantis.model.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerImpl {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Assert.state(requestAttributes != null, "Could not find current request via RequestContextHolder");
        Assert.isInstanceOf(ServletRequestAttributes.class, requestAttributes);
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        Assert.state(servletRequest != null, "Could not find current HttpServletRequest");
        return servletRequest;
    }


    @ExceptionHandler(HandleExceptionGetUsers.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionGetUsers(Exception ex) {
        log.error(" -- ERROR PAGANTIS: Users not found {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_GET_USERS.getCode(), HttpStatus.NOT_ACCEPTABLE,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_GET_USERS.getMessage(),getCurrentRequest().getMethod(),new Date());
    }

    @ExceptionHandler(HandleExceptionTransaction.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionGetTrans(Exception ex) {
        log.error(" -- ERROR PAGANTIS: Transaction error {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_TRANSACTION.getCode(), HttpStatus.NOT_ACCEPTABLE,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_TRANSACTION.getMessage(),getCurrentRequest().getMethod(),new Date());
    }

    @ExceptionHandler(HandleExceptionWalletsByUserId.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionWalletsByUserId(Exception ex) {
        log.error(" -- ERROR PAGANTIS: Filter error {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_WALLETS_BY_USERID.getCode(), HttpStatus.NOT_ACCEPTABLE,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_WALLETS_BY_USERID.getMessage(),getCurrentRequest().getMethod(),new Date());
    }

    @ExceptionHandler(HandleExceptionWalletsByUserName.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionWalletsByUserName(Exception ex) {
        log.error(" -- ERROR PAGANTIS: Filter error {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_WALLETS_BY_USERNAME.getCode(), HttpStatus.NOT_ACCEPTABLE,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_WALLETS_BY_USERNAME.getMessage(),getCurrentRequest().getMethod(),new Date());
    }

}
