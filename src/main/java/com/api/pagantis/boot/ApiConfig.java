package com.api.pagantis.boot;

import com.api.pagantis.dao.UserDao;
import com.api.pagantis.service.UserService;
import com.api.pagantis.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

 /*   @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }*/
}
