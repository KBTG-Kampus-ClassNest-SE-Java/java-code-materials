package com.example.securitycourse.controller;

import com.example.securitycourse.authentication.AuthenticationUserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    public AuthenticationController(AuthenticationManager authenticationManager, AuthenticationUserDetailService authenticationUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.authenticationUserDetailService = authenticationUserDetailService;
    }

    @PostMapping(value = "/authenticate")
    public String authenticated(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication auhen = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password()));
        return authenticationUserDetailService.generateJwt(authenticationRequest.username());
//        UserDetails user = userDao.findUserByEmail(authenticationRequest.email());
//        if (user != null) {
//            return ResponseEntity.ok(jwtUtils.generateToken(user));
//        }
//        return ResponseEntity.status(400).body("err");
    }
}
record AuthenticationRequest(String username, String password){}
