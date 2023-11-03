package com.example.javacourse.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

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
        this.userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        this.userService.editUserById(id, requestDto);
    }

}

record UserRequestDto(String name, Integer age) {}