package com.abhijeet.nexum.auth.service.impl;

import com.abhijeet.nexum.auth.dtos.AuthResponseDto;
import com.abhijeet.nexum.auth.dtos.LoginRequestDto;
import com.abhijeet.nexum.auth.dtos.RegisterRequestDto;
import com.abhijeet.nexum.auth.mapper.AuthMapper;
import com.abhijeet.nexum.auth.security.JwtUtil;
import com.abhijeet.nexum.auth.service.AuthService;
import com.abhijeet.nexum.user.domain.User;
import com.abhijeet.nexum.user.enums.Role;
import com.abhijeet.nexum.user.repo.UserRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;
    private final UserRepository repository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;



    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        if (!repository.existsByEmail(loginRequestDto.getEmail())) {
            throw new RuntimeException("User not found");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );

        User user = repository.findByEmail(loginRequestDto.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponseDto(token, user.getEmail(), user.getName());
    }
    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto) {
        if (repository.existsByEmail(registerRequestDto.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }

        User user = authMapper.toEntity(registerRequestDto);

        user.setPassword(encoder.encode(registerRequestDto.getPassword()));
        if (registerRequestDto.getRole() != null) {
            user.setRole(registerRequestDto.getRole());
        } else {
            user.setRole(Role.CUSTOMER);
        }
        repository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponseDto(token, user.getEmail(), user.getName());
    }

}
