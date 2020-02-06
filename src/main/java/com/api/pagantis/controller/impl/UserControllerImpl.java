package com.api.pagantis.controller.impl;

import com.api.pagantis.controller.UserController;
import com.api.pagantis.model.dto.UserDTO;
import com.api.pagantis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class UserControllerImpl implements UserController {

    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers(Pageable pageable) {
        log.info(" -- GET /users");
        return new ResponseEntity<>(userService.getUsers(pageable),HttpStatus.OK);
    }
}
