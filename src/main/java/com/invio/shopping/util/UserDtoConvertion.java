package com.invio.shopping.util;

import com.invio.shopping.dto.UserResponse;
import com.invio.shopping.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {


    public static List<UserResponse> convertUserList(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        users.stream().forEach(user -> userResponses.add(new UserResponse(user.getId()
        ,user.getName(),user.getSurname(),user.getEmail())));
        return userResponses;
    }

    public static UserResponse convertUser(User user){
        return new UserResponse(user.getId(), user.getEmail(), user.getSurname(), user.getEmail());
    }
}
