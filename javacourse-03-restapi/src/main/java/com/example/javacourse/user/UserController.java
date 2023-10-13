package com.example.javacourse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @PostMapping("")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        userService.editUserById(id, requestDto);
    }
}


record UserRequestDto(String name, Integer age) {}
