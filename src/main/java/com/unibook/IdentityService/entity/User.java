package com.unibook.IdentityService.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    String fullName;
    Boolean isEnabled = true;
    Boolean isLocked = false;

    @CreatedDate
    LocalDateTime createAt;
    @LastModifiedDate
    LocalDateTime updateAt;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles = new HashSet<>();
}
