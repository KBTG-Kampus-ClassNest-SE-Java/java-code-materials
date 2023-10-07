package com.example.javacourse.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("")
    public List<User> getUserList() {
        return List.of
                (
                        new User("Alice", 20, true),
                        new User("Mike", 22, true),
                        new User("Miko", 22, false)
                );
    }

}
