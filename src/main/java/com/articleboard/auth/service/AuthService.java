package com.articleboard.auth.service;

import com.articleboard.auth.dto.LoginRequestDto;
import com.articleboard.auth.dto.TokenResponseDto;
import com.articleboard.global.security.CustomUserDetails;
import com.articleboard.global.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public TokenResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(
                userDetails.getUsername(),
                userDetails.getUser().getRole().name(),
                userDetails.getUser().getUserId()
        );
        return new TokenResponseDto(token);
    }
}
