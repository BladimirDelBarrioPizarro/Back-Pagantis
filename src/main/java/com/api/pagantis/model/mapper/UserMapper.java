package com.api.pagantis.model.mapper;

import com.api.pagantis.model.dto.UserDTO;
import com.api.pagantis.model.entity.User;

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

}
