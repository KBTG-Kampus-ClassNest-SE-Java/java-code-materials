package com.example.securitycourse.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
//    hasRole('ADMIN') or
    @GetMapping("")
    public String getResource() {
        return "Get Member Resource";
    }

    @PutMapping("")
    @PreAuthorize("hasRole('MEMBER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MEMBER')")
    public String updateResource() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return "Update Member Resource";
    }

}
