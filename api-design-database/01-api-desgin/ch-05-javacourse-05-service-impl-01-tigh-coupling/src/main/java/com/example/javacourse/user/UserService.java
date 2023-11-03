package com.example.javacourse.user;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private List<User> userList = new ArrayList<>(
            List.of(new User(1,"Alice", 20, true),
                    new User(2,"Mike", 22, true),
                    new User(3,"Miko", 22, false))
    );

    public List<User> getUserList() {
        return userList;
    }

    public User createUser(UserRequestDto requestDto) {
        Optional<Integer> maxId = userList.stream()
                .map(User::getId)
                .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        User user = new User(nextId,requestDto.name(), requestDto.age(), false);

        userList.add(user);
        return user;
    }

    public void deleteUserById(@PathVariable Integer id) {
        userList.removeIf(user1 -> user1.getId().equals(id));
    }

    public void editUserById(Integer id, UserRequestDto requestDto) {
        for (User user: userList) {
            if (user.getId().equals(id)) {
                user.setName(requestDto.name());
                break;
            }
        }
    }
}
