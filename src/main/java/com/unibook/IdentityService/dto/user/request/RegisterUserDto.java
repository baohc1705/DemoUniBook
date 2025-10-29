package com.unibook.IdentityService.dto.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDto {

    @NotBlank(message = "Username not empty")
    @Size(min = 6, max = 100, message = "Username must to have 6-100 character")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username only have character and number")
    private String username;

    @NotBlank(message = "Email not empty")
    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Full name not empty")
    private String fullName;

    @NotBlank(message = "Password not empty")
    @Size(min = 8, message = "Password must to have least 8 character")
    private String password;

    @NotBlank(message = "Confirm password not empty")
    private String confirmPassword;
}
