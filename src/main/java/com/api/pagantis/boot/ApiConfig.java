package com.api.pagantis.boot;

import com.api.pagantis.controller.UserController;
import com.api.pagantis.controller.WalletController;
import com.api.pagantis.controller.impl.UserControllerImpl;
import com.api.pagantis.controller.impl.WalletControllerImpl;
import com.api.pagantis.dao.UserDao;
import com.api.pagantis.dao.WalletDao;
import com.api.pagantis.service.UserService;
import com.api.pagantis.service.WalletService;
import com.api.pagantis.service.impl.UserServiceImpl;
import com.api.pagantis.service.impl.WalletServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public WalletService walletService(WalletDao walletDao){
        return new WalletServiceImpl(walletDao);
    }

    @Bean
    public UserController userController(UserService userService){
        return new UserControllerImpl(userService);
    }

    @Bean
    public WalletController walletController(WalletService walletService){
        return new WalletControllerImpl(walletService);
    }

}
