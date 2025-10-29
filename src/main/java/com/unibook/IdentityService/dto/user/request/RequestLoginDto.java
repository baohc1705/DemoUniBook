package com.unibook.IdentityService.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestLoginDto {
    @NotBlank(message = "Username not empty")
    String username;

    @NotBlank(message = "password not empty")
    String password;
}
