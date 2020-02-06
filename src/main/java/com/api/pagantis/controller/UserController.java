package com.api.pagantis.controller;

import com.api.pagantis.model.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1")
public interface UserController {
    @GetMapping(path="/users",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDTO>> getUsers(@Param("pageable") Pageable pageable);
}
