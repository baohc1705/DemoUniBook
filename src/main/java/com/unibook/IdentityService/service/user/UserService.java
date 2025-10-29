package com.unibook.IdentityService.service.user;

import com.unibook.IdentityService.dto.user.request.RegisterUserDto;
import com.unibook.IdentityService.dto.user.request.RequestLoginDto;
import com.unibook.IdentityService.dto.user.response.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerUser(RegisterUserDto request);
    UserDto login(RequestLoginDto requestLoginDto);
}
