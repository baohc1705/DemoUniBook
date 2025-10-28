package com.unibook.IdentityService.service.role;

import com.unibook.IdentityService.dto.role.RoleDto;
import com.unibook.IdentityService.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAlls();
}
