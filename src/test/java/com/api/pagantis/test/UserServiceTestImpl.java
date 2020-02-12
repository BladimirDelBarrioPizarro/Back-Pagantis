package com.api.pagantis.test;

import com.api.pagantis.model.dto.UserDTO;
import com.api.pagantis.service.UserService;
import com.api.pagantis.test.dummy.UserServiceDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestImpl {

    private UserService userService = mock(UserService.class);

    @Test
    void getUsersTest(){
        PageRequest pageable = UserServiceDummy.pageRequestDummy();
        List<UserDTO> userDTOS = UserServiceDummy.userDTOListDummy();
        when(userService.getUsers(any())).thenReturn(userDTOS);
        List<UserDTO> userDTOS1 = userService.getUsers(pageable);
        assert (userDTOS1.size()>0);
    }
}
