package com.example.securitycourse.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class ApiKeyAuthFilter extends OncePerRequestFilter {

    private final String HEADER_NAME = "X-API-KEY";
    private final String API_KEY = "your-api-key"; // This should be stored securely and not hardcoded

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String apiKey = request.getHeader(HEADER_NAME);
        if (StringUtils.hasLength(apiKey) && API_KEY.equals(apiKey)) {
            // The token is valid, so we set the authentication in the security context
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(apiKey, null, Collections.emptyList()));
        }

        filterChain.doFilter(request, response);
    }
}
