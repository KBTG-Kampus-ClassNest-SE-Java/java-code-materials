package com.example.securitycourse;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
                .addFilterBefore(new ApiKeyAuthFilter(), BasicAuthenticationFilter.class)
                .httpBasic(withDefaults())
                .build();
    }
}
