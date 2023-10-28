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
    @GetMapping("")
    @PreAuthorize("hasAuthority('MEMBER_READ') or hasRole('ADMIN')")
    public String getResource() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Get Member Resource";
    }

    @PutMapping("")
    public String updateResource() {
        return "Update Member Resource";
    }

}
