package com.example.javacourse.wallet;

public class Wallet {

    private Integer id;
    private String name;

    private String email;

    public String getEmail() {
        return email;
    }

    public Wallet(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
