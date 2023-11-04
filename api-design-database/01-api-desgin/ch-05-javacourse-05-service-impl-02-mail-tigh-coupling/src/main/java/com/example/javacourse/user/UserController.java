package com.example.javacourse.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

   public UserController() {
        this.userService = new UserService();
   }

    @GetMapping("")
    public List<User> getUserList() {
        return userService.getUsers();
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
