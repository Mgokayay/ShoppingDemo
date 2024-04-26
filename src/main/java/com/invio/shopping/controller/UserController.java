package com.invio.shopping.controller;

import com.invio.shopping.dto.UserResponse;
import com.invio.shopping.entity.User;
import com.invio.shopping.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public List<UserResponse>  findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserResponse save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public UserResponse delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @PutMapping("/param")
    public UserResponse update(@RequestParam Long id,@RequestParam String name
            ,@RequestParam String surname,@RequestParam String email){
        return userService.update(name,surname,email,id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        try {
            String newPassword = requestBody.get("password");
            userService.updatePassword(newPassword, id);
            return ResponseEntity.ok("Password updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
