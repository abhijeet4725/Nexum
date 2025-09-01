package com.abhijeet.nexum.auth.mapper;

import com.abhijeet.nexum.auth.dtos.RegisterRequestDto;
import com.abhijeet.nexum.user.domain.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public User toEntity(RegisterRequestDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword()) // Will encode later
                .build();
    }

}
