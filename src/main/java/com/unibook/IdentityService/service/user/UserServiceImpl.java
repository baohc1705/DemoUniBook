package com.unibook.IdentityService.service.user;

import com.unibook.IdentityService.dto.user.request.RegisterUserDto;
import com.unibook.IdentityService.dto.user.request.RequestLoginDto;
import com.unibook.IdentityService.dto.user.response.UserDto;
import com.unibook.IdentityService.entity.Role;
import com.unibook.IdentityService.entity.User;
import com.unibook.IdentityService.mapper.UserMapper;
import com.unibook.IdentityService.repository.RoleRepository;
import com.unibook.IdentityService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public UserDto registerUser(RegisterUserDto request) {
        // DTO -> Enity de luu db
        User user = userMapper.toEntity(request);

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(role);
        user.setRoles(roles);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto login(RequestLoginDto requestLoginDto) {
        /*
        *  Username password
        *  requestLoginDto (username, password)
        *
        * */
        User user = userRepository.findByUsername(requestLoginDto.getUsername())
                .orElseThrow(()->new RuntimeException("User not found with username: " + requestLoginDto.getUsername()));
        if (!user.getPassword().equals(requestLoginDto.getPassword()))
            throw new RuntimeException("Login failed!");
        return userMapper.toDto(user);
    }
}
