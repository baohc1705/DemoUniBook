package com.unibook.IdentityService.mapper;

import com.unibook.IdentityService.dto.user.request.RegisterUserDto;
import com.unibook.IdentityService.dto.user.response.UserDto;
import com.unibook.IdentityService.entity.Role;
import com.unibook.IdentityService.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "isLocked", constant = "false")
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toEntity (RegisterUserDto userDto);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "rolesToRoleName")
    UserDto toDto(User user);

    @Named("rolesToRoleName")
    default Set<String> rolesToRoleName(Set<Role> roles) {
        return roles.stream()
                .map(role -> role.getName())
                .collect(Collectors.toSet());
    }
}
