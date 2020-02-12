package com.api.pagantis.test.dummy;

import com.api.pagantis.model.dto.UserDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.Collections;
import java.util.List;

public class UserServiceDummy {

   public static List<UserDTO> userDTOListDummy(){
        return Collections.singletonList(userDTODummy());
    }

    public static UserDTO userDTODummy() {
       return UserDTO.builder()
               .id(1L)
               .department("Department Test")
               .name("Name Test")
               .build();
    }


    public static PageRequest pageRequestDummy(){
        return  PageRequest.of(0, 5, Sort.Direction.DESC, "name");
    }
}
