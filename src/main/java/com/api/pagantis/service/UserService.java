package com.api.pagantis.service;


import com.api.pagantis.model.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers(Pageable pageable);
}
