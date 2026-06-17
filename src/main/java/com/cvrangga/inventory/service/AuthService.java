package com.cvrangga.inventory.service;

import com.cvrangga.inventory.dto.LoginRequest;
import com.cvrangga.inventory.dto.LoginResponse;
import com.cvrangga.inventory.security.JwtUtil;
import com.cvrangga.inventory.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(authentication);
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        return new LoginResponse(token, principal.getUsername(), principal.getFullName(), principal.getRole());
    }
}
