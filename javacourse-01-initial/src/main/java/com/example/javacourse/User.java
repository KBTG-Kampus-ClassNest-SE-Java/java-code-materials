package com.example.javacourse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("age")
    private Integer age;
    private Boolean active;

    public User(String name, Integer age, Boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}
