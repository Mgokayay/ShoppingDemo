package com.invio.shopping.service;

import com.invio.shopping.dto.UserResponse;
import com.invio.shopping.entity.User;

import java.util.List;

public interface UserService {

    UserResponse save(User user);

    UserResponse delete(Long id);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse update(String name,String surname,String email,Long id);

    UserResponse updatePassword(String password,Long id);

    User findByUserId(Long id);
}
