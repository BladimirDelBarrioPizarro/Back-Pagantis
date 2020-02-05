package com.api.pagantis.dao;
import com.api.pagantis.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserDao extends PagingAndSortingRepository<User, Long> {
}
