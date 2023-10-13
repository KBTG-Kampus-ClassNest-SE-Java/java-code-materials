package com.example.javacourse.user;

import com.example.javacourse.mail.MailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final MailService mailService;

    public UserService(MailService mailService) {
        this.mailService = mailService;
    }

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
        this.mailService.sendMail("admin@mail.com", "Create user "+ user.getName());
        return user;
    }

    public void deleteById(Integer id) {
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
