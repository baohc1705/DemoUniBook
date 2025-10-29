package com.unibook.IdentityService.controller.role;

import com.unibook.IdentityService.dto.role.RoleDto;
import com.unibook.IdentityService.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public String findAll(Model model) {
        List<RoleDto> roles = roleService.findAlls();
        model.addAttribute("name", "Huynh chi bao");
        model.addAttribute("roles", roles);
        return "index";
    }
}
