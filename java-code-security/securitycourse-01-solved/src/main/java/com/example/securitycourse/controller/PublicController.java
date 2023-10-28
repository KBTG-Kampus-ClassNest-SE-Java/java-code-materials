package com.example.securitycourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

//    http://localhost:8080/public
//    user
    @GetMapping("")
    public String getResource() {
        return "Public Resource";
    }

}
