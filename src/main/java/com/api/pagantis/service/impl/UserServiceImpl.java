package com.api.pagantis.service.impl;

import com.api.pagantis.dao.UserDao;
import com.api.pagantis.model.dto.UserDTO;
import com.api.pagantis.model.entity.User;
import com.api.pagantis.model.exceptions.HandleExceptionGetUsers;
import com.api.pagantis.model.mapper.UserMapper;
import com.api.pagantis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDTO> getUsers(Pageable pageable) {
        pageable = pageRequest(pageable);
        List<User> userLists;
        try {
            userLists = userDao.findAll(pageable).stream().collect(Collectors.toList());
            return UserMapper.mapUserListToUserDTOList(userLists);
        }catch (Exception ex){
            log.error(" -- ERROR PAGANTIS {}",ex.getMessage());
            throw new HandleExceptionGetUsers(ex);
        }
    }

    private PageRequest pageRequest(Pageable pageable){
        Sort sort = pageable.getSort();
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
    }
}
