package com.unibook.IdentityService.service.role;

import com.unibook.IdentityService.dto.role.RoleDto;
import com.unibook.IdentityService.entity.Role;
import com.unibook.IdentityService.mapper.RoleMapper;
import com.unibook.IdentityService.mapper.RoleMapperMS;
import com.unibook.IdentityService.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapperMS roleMapperMS;
    @Override
    public List<RoleDto> findAlls() {
//        List<Role> roles = roleRepository.findAll();
//        List<RoleDto> roleDtos = new ArrayList<>();
//        for (Role role : roles) {
////            RoleDto roleDto = new RoleDto();
////            roleDto.setId(role.getId());
////            roleDto.setName(role.getName());
////            roleDto.setDescription(role.getDescription());
////            roleDtos.add(roleDto);
//            roleDtos.add(RoleMapper.toRoleDto(role));
//        }
//        return roleDtos;
//        return roleRepository.findAll() // List<Role> roles  for (Role item : roles) item.id =
//                .stream()
//                .map(role -> RoleMapper.toRoleDto(role))
//                .collect(Collectors.toList());
        return roleMapperMS.toListRoleDto(roleRepository.findAll());
    }
}
