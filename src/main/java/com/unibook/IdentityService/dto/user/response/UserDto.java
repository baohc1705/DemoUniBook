package com.unibook.IdentityService.dto.user.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    String id;
    String username;
    String email;
    String fullName;
    Boolean isEnabled;
    Boolean isLocked;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    Set<String> roles = new HashSet<>(); // Role name
}
