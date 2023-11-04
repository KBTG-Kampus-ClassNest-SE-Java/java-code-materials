## Step 1: Create User
```java
package com.example.javacourse.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean active;

    public User(Integer id, String name, Integer age, Boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }
}
```

## Step 2: Create UserController (Read)
```java
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
}
```

## Step 3: Create UserController (Create) and DTO
```java
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

}

record UserRequestDto(String name, Integer age) {}
```

## Step 4: Create UserController (Update)
```java
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
```

## Step 5: Create UserController (Delete)
```java
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
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        users.removeIf(user1 -> user1.getId().equals(id));
    }

}
```




## Optional Step
```java
@RestController
@RequestMapping("/api/users")
class UserController {
    
    // /api/users?active=true
    @GetMapping("")
    public List<User> getUserList(@RequestParam("active") Optional<Boolean> active) {
        return active.map(aBoolean -> users.stream()
                .filter(user -> user.getActive().equals(aBoolean))
                .collect(Collectors.toList())).orElseGet(() -> users);
    }

    // /api/users?name=Alice
    @GetMapping("")
    public List<User> getUserList(@RequestParam("name") Optional<String> name) {
        return name.map(s -> users.stream()
                .filter(user -> user.getName().equals(s))
                .collect(Collectors.toList())).orElseGet(() -> users);
    }

    // /api/users?name=Alice&active=true
    @GetMapping("")
    public List<User> getUserList(@RequestParam("name") Optional<String> name, @RequestParam("active") Optional<Boolean> active) {
        return users.stream()
                .filter(user -> name.isEmpty() || user.getName().equals(name.get()))
                .filter(user -> active.isEmpty() || user.getActive().equals(active.get()))
                .collect(Collectors.toList());
    }
    
}
```