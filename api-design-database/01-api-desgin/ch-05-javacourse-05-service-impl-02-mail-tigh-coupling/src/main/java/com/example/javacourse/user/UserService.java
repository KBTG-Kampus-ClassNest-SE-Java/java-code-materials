package com.example.javacourse.user;

import com.example.javacourse.mail.GoogleMailService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class UserService {

    private List<User> users = List.of(
            new User(1, "Alice", 20, true),
            new User(2, "Mike", 22, true),
            new User(3, "Miko", 22, false)
    );

    private final GoogleMailService googleMailService;

    public UserService() {
        this.googleMailService = new GoogleMailService();
        this.googleMailService.setMailServer("mail.google.com");
        this.googleMailService.setPort("41");
    }


    public List<User> getUsers() {
        return users;
    }

    public User createUser(UserRequestDto requestDto) {
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        User user = new User(nextId, requestDto.name(), requestDto.age(), false);

        users.add(user);

        googleMailService.sendEmail("admin@gmail.com", "");

        return user;
    }

    public void deleteUserById(@PathVariable Integer id) {
        users.removeIf(user1 -> user1.getId().equals(id));
    }

    public void editUserById(Integer id, UserRequestDto requestDto) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(requestDto.name());
                break;
            }
        }
    }
}
