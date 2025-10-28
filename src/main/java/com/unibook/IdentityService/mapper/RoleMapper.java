package com.unibook.IdentityService.mapper;

import com.unibook.IdentityService.dto.role.RoleDto;
import com.unibook.IdentityService.entity.Role;

import java.util.List;

public class RoleMapper {
    public static RoleDto toRoleDto(Role role) {
//        RoleDto roleDto = new RoleDto();
//        roleDto.setId(role.getId());
//        roleDto.setName(role.getName());
//        roleDto.setDescription(role.getDescription());
//        return roleDto;

        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public static List<RoleDto> toListRoleDto(List<Role> roles) {
        return roles.stream().map(RoleMapper::toRoleDto).toList();
    }
}
