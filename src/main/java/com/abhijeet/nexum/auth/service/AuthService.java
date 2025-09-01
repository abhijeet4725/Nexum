package com.abhijeet.nexum.auth.service;

import com.abhijeet.nexum.auth.dtos.AuthResponseDto;
import com.abhijeet.nexum.auth.dtos.LoginRequestDto;
import com.abhijeet.nexum.auth.dtos.RegisterRequestDto;
import com.abhijeet.nexum.user.domain.User;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto loginRequestDto);
    AuthResponseDto register(RegisterRequestDto registerRequestDto);
}
