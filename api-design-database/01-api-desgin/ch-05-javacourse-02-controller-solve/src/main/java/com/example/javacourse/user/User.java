package com.example.javacourse.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
//    @JsonProperty("user_name")
    private String name;
    private Integer age;
    private Boolean active;

    public User(String name, Integer age, Boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

//    public String getName() {
//        return name;
//    }

    public String getUserName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }
//
//    public Boolean isActive() {
//        return active;
//    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
