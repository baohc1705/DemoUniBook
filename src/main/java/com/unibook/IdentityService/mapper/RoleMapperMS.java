package com.unibook.IdentityService.mapper;

import com.unibook.IdentityService.dto.role.RoleDto;
import com.unibook.IdentityService.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapperMS {
    // Role -> RoleDto
    @Mapping(target = "description", ignore = true)
    RoleDto toRoleDto(Role role);

    // List<Role> -> List<RoleDto>
    List<RoleDto> toListRoleDto(List<Role> roles);
}
