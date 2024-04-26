package com.invio.shopping.service;

import com.invio.shopping.dto.UserResponse;
import com.invio.shopping.entity.User;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.UserRepository;
import com.invio.shopping.util.UserDtoConvertion;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;



    @Override
    public UserResponse save(User user) {
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponse delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
              userRepository.delete(userOptional.get());
              return UserDtoConvertion.convertUser(userOptional.get());
        }
        throw new CommonException("User not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<UserResponse> findAll() {
        return UserDtoConvertion.convertUserList(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return UserDtoConvertion.convertUser(userOptional.get());
        }
        throw new CommonException("User not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse update(String name,String surname,String email, Long id) {
        Optional<User> user1 = userRepository.findById(id);
        if(user1.isPresent()){
            User existingUser = user1.get();
            existingUser.setName(name);
            existingUser.setSurname(surname);
            existingUser.setEmail(email);
            existingUser.setPassword(user1.get().getPassword());
            userRepository.save(existingUser);
            return UserDtoConvertion.convertUser(existingUser);
        }
        throw new CommonException("User not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse updatePassword(String password, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User existingUser = userOptional.get();
            existingUser.setPassword(password);
            userRepository.save(existingUser);
            return UserDtoConvertion.convertUser(existingUser);
        }
        throw new CommonException("User not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public User findByUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new CommonException("User not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
