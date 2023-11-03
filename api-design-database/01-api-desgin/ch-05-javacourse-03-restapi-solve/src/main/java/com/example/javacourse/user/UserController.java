package com.example.javacourse.user;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    List<User> users = new ArrayList<>(
            List.of(new User(1,"Alice", 20, true),
                    new User(2,"Mike", 22, true),
                    new User(3,"Miko", 22, false))
    );

    @GetMapping("")
    public List<User> getUserList() {
        return users;
    }

    @PostMapping("")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        Optional<Integer> maxId = users.stream()
                .map(User::getId)
                .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        User user = new User(nextId,requestDto.name(), requestDto.age(), false);

        users.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
//        User user = users.stream().filter(user -> !user.getId().equals(id)).findFirst();
        users.removeIf(user1 -> user1.getId().equals(id));
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                user.setName(requestDto.name());
                break;
            }
        }
    }

}

record UserRequestDto(String name, Integer age) {}