package com.example.securitycourse.authentication;

import com.example.securitycourse.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationUserDetailService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public String generateJwt(String username) {
        CustomUserDetail userDetail = userRepository.findUserByUsername(username);
        return jwtService.generateToken(userDetail);
    }
}
