package com.unibook.IdentityService.controller.auth;

import com.unibook.IdentityService.dto.user.request.RegisterUserDto;
import com.unibook.IdentityService.dto.user.request.RequestLoginDto;
import com.unibook.IdentityService.dto.user.response.UserDto;
import com.unibook.IdentityService.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("registerUserDto", new RegisterUserDto());
        return "auth/register";
    }

    @PostMapping("/register") // /auth/register
    public String register(@Valid @ModelAttribute RegisterUserDto registerUserDto,
                           BindingResult result,
                           RedirectAttributes redirectAttributes,
                           Model model,
                           HttpServletRequest request) {
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            UserDto userDto = userService.registerUser(registerUserDto);
            //model.addAttribute("success", );
//            HttpSession session = request.getSession();
//            session.setAttribute("success", "Register success with user: " + userDto.getUsername());
            redirectAttributes.addFlashAttribute("success", "Register success with user: " + userDto.getUsername());
            return "redirect:/auth/register";
        } catch (Exception e) {
            model.addAttribute("error", "Server error");
            log.error(e.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/login")
    public String viewLogin(Model model) {
        model.addAttribute("requestLoginDto", new RegisterUserDto());
        return "auth/login";
    }
    // Post - Redirect - Get  PRG
    @PostMapping("/login/{id}")
    public String login(@Valid @ModelAttribute RequestLoginDto requestLoginDto,
                        BindingResult result,
                        Model model,
                        RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "auth/login";
        }
        try {
            UserDto userDto = userService.login(requestLoginDto); // -> login thanh cong -> username index xinchao huynh chi bao
            //model.addAttribute("msgSuccess", "Ban dang nhap thanh cong")
            //model.addAttribute("msgSuccess", "Xin chao " + userDto.getUsername());
            redirectAttributes.addFlashAttribute("msgSuccess", "Xin chao " + userDto.getUsername());
            return "redirect:/home";
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("msgError", "Username or password invalid");
            return "auth/login";
        }
    }
}
