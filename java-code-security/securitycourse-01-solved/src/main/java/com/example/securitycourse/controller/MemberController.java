package com.example.securitycourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping("")
    public String getResource() {
        return "Get Member Resource";
    }

    @PutMapping("")
    public String updateResource() {
        return "Update Member Resource";
    }

}
