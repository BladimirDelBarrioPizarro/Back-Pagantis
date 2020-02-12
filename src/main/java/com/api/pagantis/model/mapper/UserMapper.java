package com.api.pagantis.model.mapper;

import com.api.pagantis.model.dto.HttpErrorDTO;
import com.api.pagantis.model.dto.UserDTO;
import com.api.pagantis.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static List<UserDTO> mapUserListToUserDTOList(List<User> userLists) {
        return userLists.stream().map(UserMapper::mapUserToUserDTO).collect(Collectors.toList());
    }

    private static UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .department(user.getDepartment())
                .build();
    }

    public static ResponseEntity<HttpErrorDTO> buildHttpErrorDTO(Integer code, HttpStatus notFound, String servletPath, String message, String method, Date date) {
        return new ResponseEntity(HttpErrorDTO.builder()
                .code(code)
                .message(message)
                .method(method)
                .date(date.toString())
                .statusText(notFound.toString())
                .url(servletPath)
                .build(),HttpStatus.CONFLICT);
    }
}
